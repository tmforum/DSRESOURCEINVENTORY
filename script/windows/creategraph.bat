@echo off
if [%1]==[] goto usage
if [%2]==[] goto usage
@echo on
curl -i -X POST --data "@../json/newgraph.json" -H "Content-Type: application/json" http://localhost:8080/DSResourceInventory/webresources/inventory/resource/%1/%2/graph
@echo off
goto :eof
:usage
@echo Usage: %0 ^<TypeOfResource^> ^<ID^>