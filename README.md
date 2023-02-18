# JDBC Examples and Best Practices

Examples and best practices to connect to databases in java.

##### Resources used

* sqlite-jdbc-3.40.1.0.jar
* DB browser for SQLite 3.12.2

##### nice to know/remember

* **Statement.execute()** returns a boolean which is true if the return type is ResultSet and false for everything else. An UPDATE-Statement would return false for example because it returns the number of updates rows and not a ResultStet.
* Getting the **columns by name** from the ResultSet is ok but using the index is faster. Best Practice is using constants.