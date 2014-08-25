@echo on
curl -i -X POST --data "@../json/newEquipment.json" -H "Content-Type: application/json" http://localhost:8080/DSResourceInventory/webresources/inventory/resource/equipment
@echo off
goto :eof
:usage
@echo Usage: %0