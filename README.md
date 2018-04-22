# Opswat Client:

This program uploads file to remote opswat server to generate scan and threat reports.

The following functionalities are present,

### File Uploader :
Scan file for threat and retrieves data id for the uploaded file .

### LookUp by DataID:
Retrieves the hash and the scan report given a dataId.

### LookUp by Hash
Performs a hash lookup against to see if the file and hash are previously cached, If it is cached,
it displays the scan report by retrieving the results using the saved Hash. 

### Project External Dependencies:
 
* Json - JSON processing library which can be used to read JSON, write JSON file. 
* Gson - Gson is a Java library that can be used to convert Java Objects into their JSON representation.
* Retrofit - Is a Rest Adapter.
* okhttp3 -  A popular HTTP client.

## Usage:

```
Enter your apikey in 
api.json(Interview /src /main/ resources/api.json)
```

### Adding a File : 

```
To add a file to upload under resources folder in the java project( Interview /src /main/ resources/)
```

Run the program.
