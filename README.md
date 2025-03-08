# psdn-system-api

### Start MSSQL Server as container

```bash
docker run -e 'ACCEPT_EULA=Y' -e 'SA_PASSWORD=SomePassword1@' -e 'MSSQL_PID=Developer' \
-p 1433:1433 -d --name sql mcr.microsoft.com/azure-sql-edge
```

### Create a Database
```bash
sqlcmd -S localhost -U sa -P 'SomePassword1@' -C
```

```sql
CREATE DATABASE MLPNZD;
go
```

