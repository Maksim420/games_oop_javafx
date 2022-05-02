package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BishopBlackTest {

    @Test
    public void whenPositionC8() {
        Cell position = Cell.C8;
        BishopBlack bishopBlack = new BishopBlack(position);
        assertThat(bishopBlack.position(), is(position));
    }

    @Test
    public void whenCopyFromC8ToE6() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Cell dest = Cell.E6;
        Figure newBlackBishop = bishopBlack.copy(dest);
        assertThat(newBlackBishop.position(), is(dest));
    }

    @Test
    public void whenWayFromC1ToG5() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Cell[] excepted = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(bishopBlack.way(Cell.G5), is(excepted));
    }

    @Test
    public void whenWayFromC8ToE6() {
        Figure bishopBlack = new BishopBlack(Cell.C8);
        Cell[] excepted = {Cell.D7, Cell.E6};
        assertThat(bishopBlack.way(Cell.E6), is(excepted));
    }

    @Test
    public void whenWayFromF5ToC8() {
        Figure bishopBlack = new BishopBlack(Cell.F5);
        Cell[] excepted = {Cell.E6, Cell.D7, Cell.C8};
        assertThat(bishopBlack.way(Cell.C8), is(excepted));
    }

    @Test
    public void whenWayFromC8ToA6() {
        Figure bishopBlack = new BishopBlack(Cell.C8);
        Cell[] excepted = {Cell.B7, Cell.A6};
        assertThat(bishopBlack.way(Cell.A6), is(excepted));
    }

    @Test (expected = ImpossibleMoveException.class)
    public void whenIsNotDiagonal() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        bishopBlack.way(Cell.C2);
    }
}