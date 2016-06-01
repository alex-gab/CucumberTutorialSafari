package com.alex.nicebank;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.List;

public final class Steps {

    private List<List<String>> board;

    @Given("^a board like this:$")
    public void aBoardLikeThis(final DataTable table) throws Throwable {
        board = new ArrayList<>();
        for (List<String> row : table.raw()) {
            board.add(new ArrayList<>(row));
        }
    }

    @When("^player x plays in row (\\d+), column (\\d+)$")
    public void playerXPlaysinRowColumn(final int row, final int column) throws Throwable {
        board.get(row).set(column, "x");
    }

    @Then("the board should look like this:")
    public void theBoardShouldLookLikeThis(final DataTable expectedTable) throws Throwable {
        expectedTable.diff(board);
    }
}
