@echo off
if [%1]==[] goto usage
if [%2]==[] goto usage
@echo on
curl -i -X DELETE -H "Content-Type: application/json" http://localhost:8080/DSResourceInventory/webresources/inventory/resource/%1/%2
@echo off
goto :eof
:usage
@echo Usage: %0 ^<TypeOfResource^> ^<ID^>