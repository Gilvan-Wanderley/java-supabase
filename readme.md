# Java Supabase

This is a library that makes it easier to use Supabase database with Java. By creating a client that uses REST API Supabase request to access and edit information in the database.


# Commands
1. **_getPaginate_** (<span style="color:#18864b">**Integer**</span> _start_, <span style="color:#18864b">**Integer**</span> _end_)

    * **Description**: This method retrieves a paginated subset of records from a table. It sends a GET request to the specified URL with range headers to specify the start and end indices of the records to be fetched.
    * **Parameters**:
        * `start`: The starting index of the records to fetch.
        * `end`: The ending index of the records to fetch.
    * **Returns**: An <span style="color:#18864b">HttpResponse</span><<span style="color:#155ca2">_String_</span>> containing the response from the server or null if an exception occurs.

2. **_getBy_** (<span style="color:#18864b">**String**</span> _columnName_, <span style="color:#18864b">**String**</span> _value_)
    * **Description**: This method retrieves records from a table where the value of a specified column matches a given value. It sends a GET request to the specified URL with query parameters to filter the results.
    * **Parameters**:
        * `columnName`: The name of the column to filter by.
        * `value`: The value to match in the specified column.
    * **Returns**: An <span style="color:#18864b">HttpResponse</span><<span style="color:#155ca2">_String_</span>> containing the response from the server or null if an exception occurs.

3. **_insert_** (<span style="color:#18864b">**String**</span> _body_)
    * Description: This method inserts a new record into a table. It sends a POST request with the body containing the data to be inserted in JSON format.
    * Parameters:
        * `body`: A JSON string containing the data to be inserted.
    * Returns: An <span style="color:#18864b">HttpResponse</span><<span style="color:#155ca2">_String_</span>> containing the response from the server or null if an exception occurs.

4. **_edit_** (<span style="color:#18864b">**String**</span> _columnName_, <span style="color:#18864b">**String**</span> _value_, <span style="color:#18864b">**String**</span> _body_)
    * **Description**: This method updates existing records in a table where the value of a specified column matches a given value. It sends a PATCH request with the body containing the updated data in JSON format.
    * **Parameters**:
        * `columnName`: The name of the column to filter by.
        * `value`: The value to match in the specified column.
        * `body`: A JSON string containing the updated data.
    * **Returns**: An <span style="color:#18864b">HttpResponse</span><<span style="color:#155ca2">_String_</span>> containing the response from the server or null if an exception occurs.

5. **_delete_** (<span style="color:#18864b">**String**</span> _columnName_, <span style="color:#18864b">**String**</span> _value_)
    * **Description**: This method deletes records from a table where the value of a specified column matches a given value. It sends a DELETE request to the specified URL with query parameters to filter the records to be deleted.
    * **Parameters**:
        * `columnName`: The name of the column to filter by.
        * `value`: The value to match in the specified column.
    * **Returns**: An <span style="color:#18864b">HttpResponse</span><<span style="color:#155ca2">_String_</span>> containing the response from the server or null if an exception occurs.