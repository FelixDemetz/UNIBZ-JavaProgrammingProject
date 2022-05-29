module projectgrouplf {
    requires javafx.fxml;
    requires transitive javafx.controls;
    requires transitive javafx.graphics;

    requires transitive java.desktop; // for java swing (JPane, ...)

    opens projectgrouplf;
    exports projectgrouplf;
}