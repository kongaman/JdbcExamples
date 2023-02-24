# JDBC Examples and Best Practices

Examples and best practices to connect to databases in java.

##### Resources used

* sqlite-jdbc-3.40.1.0.jar
* DB browser for SQLite 3.12.2

##### Nice to know/remember

- **Statement.execute()** returns a boolean which is true if the return type is ResultSet and false for everything else. An UPDATE-Statement would return false for example because it returns the number of updates rows and not a ResultStet.
- Getting the **columns by name** from the ResultSet is ok but **using the index is faster**. Best Practice is using constants. However if you use column names you don't have to change anything if there's a new column in the table, whereby the index might change.
- **Do not return ResultSets** from methods that get data from the database, so that your later methods don't have to know about datasource details. If you change your datasource to something else you only have to change the code in the model-package. **Better to return Lists of DataModelObjects** (Artist, Album, Song in this case).
- If you close ResulSet and Statement in the finally block, it's best practice to close them individually (each in its own try/catch-block), because if you have them both in one block if the first close() throws an error the second one will not be executed. 
- **Try with resources** is generally the way to go, it's way more concise, clean and easier to read.
- The insertSong method is an example for a **transaction**. This means you have multiple SQL statements that have to run without error and only if they do, you want the changes in the database to take place. (If you use other methods to execute some sql statements make sure they throw exception so that everything can be handled in the "main" method.
    - Turn of auto-commit
    - execute statements
    - do a commit after the last statement ran successfully
    - do a rollback in the catch-block (be careful to catch ALL Execeptions)
    - turn of auto-commit


