#!/bin/bash

case "${1:-''}" in
        'start')
                if test -f ./pid/grid.pid
                then
                        echo "Selenium Grid is already running."
                else

                  if test -f ./drivers/
                  then
                    echo "Drivers is find and ready to use"
                  else
                    echo "Drivers not found. Download drivers..."

                    mkdir ./drivers && \
                    wget https://github.com/mozilla/geckodriver/releases/download/v0.27.0/geckodriver-v0.27.0-linux64.tar.gz -P ./drivers/ && \
                    tar -xvf ./drivers/geckodriver-v0.27.0-linux64.tar.gz -C ./drivers/ &&\
                    wget https://chromedriver.storage.googleapis.com/85.0.4183.38/chromedriver_linux64.zip -P ./drivers/ &&\
                    unzip ./drivers/chromedriver_linux64.zip -d ./drivers/

                    echo "Driver download complete. Extract archive..."


                    echo "Driver extract and ready for use"
                  fi


                        if test -f ./logs
                        then
                          echo "Directory for log is created"
                        else
                          echo "Create logs directory"
                          mkdir ./logs/
                        fi

                        if test -f ./pid
                        then
                          echo "Directory for pid is created"
                        else
                          echo "Create pid directory"
                          mkdir ./pid/
                        fi

                        if test -f ./selenium-server-standalone-3.141.59.jar
                        then
                          echo "Selenium server is already downloaded"
                          else
                            wget https://selenium-release.storage.googleapis.com/3.141/selenium-server-standalone-3.141.59.jar
                        fi

                        java -jar selenium-server-standalone-3.141.59.jar -role hub > ./logs/grid.log 2> ./logs/grid-error.log & echo $! > ./pid/grid.pid
                        echo "Starting Selenium Grid..."
                        sleep 1
                        java -Dwebdriver.gecko.driver="./drivers/geckodriver" -jar selenium-server-standalone-3.141.59.jar -role webdriver -hub http://localhost:4444/grid/register -port 5556  -browser browserName=firefox,version=4,maxInstances=2> ./logs//node-firefox.log 2> ./logs//node-firefox-error.log & echo $! > ./pid/node-firefox.pid
                        echo "Starting Firefox Node"
                        sleep 1
                        java -Dwebdriver.chrome.driver="./drivers/chromedriver" -jar selenium-server-standalone-3.141.59.jar -role webdriver -hub http://localhost:4444/grid/register -port 5558 -browser browserName=chrome,version=84,maxInstances=2 > ./logs//node-chrome.log 2> ./logs//node-chrome-error.log & echo $! > ./pid/node-chrome.pid
                        echo "Starting Chrome Node"

                      error=$?
                        if test $error -gt 0
                        then
                                echo "${bon}Error $error! Couldn't start Selenium Grid!${boff}"
                        fi
                fi
        ;;
        'stop')
                if test -f ./pid/grid.pid
                then
                        echo "Stopping Selenium Grid..."
                        PID=`cat ./pid/grid.pid`
                        PIDchrome=`cat ./pid/node-chrome.pid`
                        PIDfox=`cat ./pid/node-firefox.pid`
                        kill -3 $PIDchrome
                        echo "Stopping Chrome Node"
                        sleep 1
                        kill -3 $PIDfox
                        echo "Stopping Chrome Node"
                        sleep 1
                        kill -3 $PID
                        if kill -9 $PID ;
                                then
                                        sleep 2
                                        test -f ./pid/grid.pid && rm -f ./pid/grid.pid && rm -fr ./pid/node-chrome.pid && ./pid/node-firefox.pid
                                else
                                        echo "Selenium Grid could not be stopped..."
                                fi
                else
                        echo "Selenium Grid is not running."
                fi
                ;;
        'restart')
                if test -f ./pid/grid.pid
                then
                        kill -HUP `cat ./pid/node-firefox.pid`
                        kill -HUP `cat ./pid/node-chrome.pid`
                        kill -HUP `cat ./pid/grid.pid`
                        test -f ./pid/grid.pid && rm -f ./pid/grid.pid && rm -fr ./pid/node-chrome.pid && ./pid/node-firefox.pid
                        sleep 1
                        java -jar selenium-server-standalone-3.141.59.jar -role hub > ./logs/grid.pid 2> ./logs/grid-error.log & echo $! > ./pid/grid.pid
                        echo "Reload Selenium Grid..."

                        sleep 1
                        java -jar selenium-server-standalone-3.141.59.jar -role webdriver -hub http://localhost:4444/grid/register -port 5556 -browser browserName=firefox > ./logs//node-firefox.log 2> ./logs//node-firefox-error.log & echo $! > ./pid/node-firefox.pid
                        echo "Starting Firefox Node"

                        sleep 1
                        java -jar selenium-server-standalone-3.141.59.jar -role webdriver -hub http://localhost:4444/grid/register -port 5558 -browser browserName=chrome > ./logs//node-chrome.log 2> ./logs//node-chrome-error.log & echo $! > ./pid/node-chrome.pid
                        echo "Starting Chrome Node"
                else
                        echo "Selenium Grid isn't running..."
                fi
                ;;
        *)      # no parameter specified
                echo "Usage: $SELF start|stop|restart|reload|force-reload|status"
                exit 1
        ;;
esac
