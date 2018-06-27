//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package org.katydom.samples.sudokusolver


//---------------------------------------------------------------------------------------------------------------------

class Cell {

    private lateinit var _block: CellGroup

    private val _candidates = mutableSetOf(0, 1, 2, 3, 4, 5, 6, 7, 8)

    private lateinit var _column: CellGroup

    private var _solved: Boolean = false

    private lateinit var _row: CellGroup

    private var _value: Int? = null

    ////

    var block: CellGroup
        get() = _block
        internal set(b) {
            _block = b
        }

    val candidates: Set<Int>
        get() = _candidates

    var column: CellGroup
        get() = _column
        internal set(c) {
            _column = c
        }

    val name: String
        get() {
            val v = _value
            return if (v != null)
                "R${row.index + 1}C${column.index + 1}#${v + 1}"
            else
                "R${row.index + 1}C${column.index + 1}"
        }

    var solved: Boolean
        get() = _solved
        internal set(s) {
            _solved = s
        }

    var row: CellGroup
        get() = _row
        internal set(r) {
            _row = r
        }

    val value: Int?
        get() = _value


    ////

    internal fun removeCandidate(candidate: Int) {

        if ( _candidates.remove(candidate) ) {
            row.removeCellCandidate(this,candidate)
            column.removeCellCandidate(this,candidate)
            block.removeCellCandidate(this,candidate)
        }

    }

    internal fun setValue(v: Int) {

        for ( c in candidates ) {
            removeCandidate(c)
        }

        _value = v

        for ( cell in row.cells ) {
            cell.removeCandidate(v)
        }

        for ( cell in column.cells ) {
            cell.removeCandidate(v)
        }

        for ( cell in block.cells ) {
            cell.removeCandidate(v)
        }

    }
}



//---------------------------------------------------------------------------------------------------------------------

class CellGroup(
    val index: Int,
    val cells: List<Cell>
) {

    internal val cellsWithCandidate = listOf(
        mutableListOf<Cell>(),
        mutableListOf(),
        mutableListOf(),
        mutableListOf(),
        mutableListOf(),
        mutableListOf(),
        mutableListOf(),
        mutableListOf(),
        mutableListOf()
    )

    init {
        for ( cellsList in cellsWithCandidate ) {
            cellsList.addAll(cells)
        }
    }

    internal fun removeCellCandidate(cell:Cell, candidate: Int) {

        // TODO: return list of actual removals

        cellsWithCandidate[candidate].remove(cell)

    }

}

//---------------------------------------------------------------------------------------------------------------------

class Board {

    private val c: List<List<Cell>> = listOf(
        listOf(Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell()),
        listOf(Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell()),
        listOf(Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell()),
        listOf(Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell()),
        listOf(Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell()),
        listOf(Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell()),
        listOf(Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell()),
        listOf(Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell()),
        listOf(Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell())
    )

    val rows = listOf(
        CellGroup(0, listOf(c[0][0], c[0][1], c[0][2], c[0][3], c[0][4], c[0][5], c[0][6], c[0][7], c[0][8])),
        CellGroup(1, listOf(c[1][0], c[1][1], c[1][2], c[1][3], c[1][4], c[1][5], c[1][6], c[1][7], c[1][8])),
        CellGroup(2, listOf(c[2][0], c[2][1], c[2][2], c[2][3], c[2][4], c[2][5], c[2][6], c[2][7], c[2][8])),
        CellGroup(3, listOf(c[3][0], c[3][1], c[3][2], c[3][3], c[3][4], c[3][5], c[3][6], c[3][7], c[3][8])),
        CellGroup(4, listOf(c[4][0], c[4][1], c[4][2], c[4][3], c[4][4], c[4][5], c[4][6], c[4][7], c[4][8])),
        CellGroup(5, listOf(c[5][0], c[5][1], c[5][2], c[5][3], c[5][4], c[5][5], c[5][6], c[5][7], c[5][8])),
        CellGroup(6, listOf(c[6][0], c[6][1], c[6][2], c[6][3], c[6][4], c[6][5], c[6][6], c[6][7], c[6][8])),
        CellGroup(7, listOf(c[7][0], c[7][1], c[7][2], c[7][3], c[7][4], c[7][5], c[7][6], c[7][7], c[7][8])),
        CellGroup(8, listOf(c[8][0], c[8][1], c[8][2], c[8][3], c[8][4], c[8][5], c[8][6], c[8][7], c[8][8]))
    )

    val columns = listOf(
        CellGroup(0, listOf(c[0][0], c[1][0], c[2][0], c[3][0], c[4][0], c[5][0], c[6][0], c[7][0], c[8][0])),
        CellGroup(1, listOf(c[0][1], c[1][1], c[2][1], c[3][1], c[4][1], c[5][1], c[6][1], c[7][1], c[8][1])),
        CellGroup(2, listOf(c[0][2], c[1][2], c[2][2], c[3][2], c[4][2], c[5][2], c[6][2], c[7][2], c[8][2])),
        CellGroup(3, listOf(c[0][3], c[1][3], c[2][3], c[3][3], c[4][3], c[5][3], c[6][3], c[7][3], c[8][3])),
        CellGroup(4, listOf(c[0][4], c[1][4], c[2][4], c[3][4], c[4][4], c[5][4], c[6][4], c[7][4], c[8][4])),
        CellGroup(5, listOf(c[0][5], c[1][5], c[2][5], c[3][5], c[4][5], c[5][5], c[6][5], c[7][5], c[8][5])),
        CellGroup(6, listOf(c[0][6], c[1][6], c[2][6], c[3][6], c[4][6], c[5][6], c[6][6], c[7][6], c[8][6])),
        CellGroup(7, listOf(c[0][7], c[1][7], c[2][7], c[3][7], c[4][7], c[5][7], c[6][7], c[7][7], c[8][7])),
        CellGroup(8, listOf(c[0][8], c[1][8], c[2][8], c[3][8], c[4][8], c[5][8], c[6][8], c[7][8], c[8][8]))
    )

    val blocks = listOf(
        CellGroup(0, listOf(c[0][0], c[0][1], c[0][2], c[1][0], c[1][1], c[1][2], c[2][0], c[2][1], c[2][2])),
        CellGroup(1, listOf(c[0][3], c[0][4], c[0][5], c[1][3], c[1][4], c[1][5], c[2][3], c[2][4], c[2][5])),
        CellGroup(2, listOf(c[0][6], c[0][7], c[0][8], c[1][6], c[1][7], c[1][8], c[2][6], c[2][7], c[2][8])),
        CellGroup(3, listOf(c[3][0], c[3][1], c[3][2], c[4][0], c[4][1], c[4][2], c[5][0], c[5][1], c[5][2])),
        CellGroup(4, listOf(c[3][3], c[3][4], c[3][5], c[4][3], c[4][4], c[4][5], c[5][3], c[5][4], c[5][5])),
        CellGroup(5, listOf(c[3][6], c[3][7], c[3][8], c[4][6], c[4][7], c[4][8], c[5][6], c[5][7], c[5][8])),
        CellGroup(6, listOf(c[6][0], c[6][1], c[6][2], c[7][0], c[7][1], c[7][2], c[8][0], c[8][1], c[8][2])),
        CellGroup(7, listOf(c[6][3], c[6][4], c[6][5], c[7][3], c[7][4], c[7][5], c[8][3], c[8][4], c[8][5])),
        CellGroup(8, listOf(c[6][6], c[6][7], c[6][8], c[7][6], c[7][7], c[7][8], c[8][6], c[8][7], c[8][8]))
    )

    init {

        for (row in rows) {
            for (cell in row.cells) {
                cell.row = row
            }
        }

        for (column in columns) {
            for (cell in column.cells) {
                cell.column = column
            }
        }

        for (block in blocks) {
            for (cell in block.cells) {
                cell.block = block
            }
        }

    }

    fun withCellValueSet(rowIndex: Int, colIndex: Int, value: Int): Board {

        val result = Board()

        for ( i in 0..8 ) {

            for ( j in 0..8 ) {

                val cell = this.rows[i].cells[j]
                val newCell = result.rows[i].cells[j]

                val oldValue = cell.value
                if ( oldValue != null && !cell.solved ) {
                    newCell.setValue( oldValue )
                }
                else if ( cell.row.index == rowIndex && cell.column.index == colIndex ) {
                    newCell.setValue( value)
                }

            }

        }

        return result

    }
}

//---------------------------------------------------------------------------------------------------------------------

/** Top-level model for this application. */
class SudokuSolverAppState(

    val board: Board = Board()

) {

    fun withCellValueSet(rowIndex: Int, colIndex: Int, value: Int): SudokuSolverAppState {

        val newBoard = this.board.withCellValueSet(rowIndex, colIndex, value)

        solve( newBoard )

        return SudokuSolverAppState( newBoard )

    }

}

//---------------------------------------------------------------------------------------------------------------------

fun solve( board: Board ) {

    var changed = true

    while ( changed ) {

        changed = false

        // naked singles
        for (row in board.rows) {

            for (cell in row.cells) {

                if (cell.candidates.size == 1) {
                    val c = cell.candidates.elementAt(0)
                    cell.setValue(c)
                    cell.solved = true
                    changed = true
                    console.log("Naked Single: ${cell.name}")
                }

            }

        }

        if ( changed ) {
            continue
        }

        // hidden singles
        for (row in board.rows) {

            for (c in 0..8) {

                if (row.cellsWithCandidate[c].size == 1) {
                    val cell = row.cellsWithCandidate[c].elementAt(0)
                    cell.setValue(c)
                    cell.solved = true
                    changed = true
                    console.log("Hidden Single: ${cell.name} for row R${row.index}.")
                }

            }

        }

        for (column in board.columns) {

            for (c in 0..8) {

                if (column.cellsWithCandidate[c].size == 1) {
                    val cell = column.cellsWithCandidate[c].elementAt(0)
                    cell.setValue(c)
                    cell.solved = true
                    changed = true
                    console.log("Hidden Single: ${cell.name} for row C${column.index}.")
                }

            }

        }

        for (block in board.blocks) {

            for (c in 0..8) {

                if (block.cellsWithCandidate[c].size == 1) {
                    val cell = block.cellsWithCandidate[c].elementAt(0)
                    cell.setValue(c)
                    cell.solved = true
                    changed = true
                    console.log("Hidden Single: ${cell.name} for block ${block.index}.")
                }

            }

        }

    }

}

//---------------------------------------------------------------------------------------------------------------------

