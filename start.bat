@echo off

set "generator_backend_path=./generator"
set "validator_backend_path=./validator"
set "frontend_app_path=./frontend"

@echo on


echo "Starting Backend Applications"


@echo off
start "Validator App" cmd /k "cd /d %generator_backend_path% & mvn spring-boot:run"
start "Generator App" cmd /k "cd /d %validator_backend_path% & mvn spring-boot:run"

@echo on
timeout /T 10 /NOBREAK


echo "Installing dependencies and Starting Frontend App"
@echo off
cd /d %frontend_app_path%
npm install && npm start
