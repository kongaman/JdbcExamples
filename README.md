# JDBC Examples and Best Practices

Examples and best practices to connect to databases in java.

##### Resources used

* sqlite-jdbc-3.40.1.0.jar
* DB browser for SQLite 3.12.2

##### Nice to know/remember

* **Statement.execute()** returns a boolean which is true if the return type is ResultSet and false for everything else. An UPDATE-Statement would return false for example because it returns the number of updates rows and not a ResultStet.
* Getting the **columns by name** from the ResultSet is ok but using the index is faster. Best Practice is using constants.
* **Do not return Resultsets** from methods that get data from the database, so that your later methods don't have to know about datasource details. If you change your datasource to something else you only have to change the code in the model-package. **Better to return Lists of DataModelObjects** (Artist, Album, Song in this case).
* If you close ResulSet and Statement in the finally block, it's best practice to close them individually (each in its own try/catch-block), because if you have them both in one block if the first close() throws an error the second one will not be executed. 