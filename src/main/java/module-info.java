module projectgrouplf {
    requires transitive javafx.fxml;
    requires transitive javafx.controls;
    requires transitive javafx.graphics;

    opens projectgrouplf;
    exports projectgrouplf;
}