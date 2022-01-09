package data;

public class DataProvider {

    @org.testng.annotations.DataProvider(name = "dataForDifference")
    public static Object[][] dataForDifferenceTest4 () {
        return new Object[][]{
                {10, 15, -5},
                {-5, -6, 1},
                {-10, 5, -15},
                {15, 0, 15}
        };
    }

    @org.testng.annotations.DataProvider (name = "dataForDivision")
    public static Object[][] dataForDivisionTest5 () {
        return new Object[][]{
                {10, 5, 2},
                {-5, -5, 1},
                {3, 2, 1.5},
                {3, 0, 0}
        };
    }
}
