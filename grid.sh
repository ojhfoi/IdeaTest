#!/bin/bash

case "${1:-''}" in
        'start')
                if test -f ./pid/grid.pid
                then
                        echo "Selenium Grid is already running."
                else
                        if test -f ./logs && -f ./pid
                        then
                          echo "Directory for log and pid is created"
                        else
                          echo "Create service directory"
                          mkdir ./logs/ && mkdir ./pid/
                        fi

                        if test -f ./selenium-server-standalone-3.141.59.jar
                        then
                          echo "Selenium server is already downloaded"
                          else
                            wget https://selenium-release.storage.googleapis.com/3.141/selenium-server-standalone-3.141.59.jar
                        fi

                        java -jar selenium-server-standalone-3.141.59.jar -role hub > ./logs/grid.log 2> ./logs/grid-error.log & echo $! > ./pid/grid.pid
                        echo "Starting Selenium Grid..."

                        java -jar selenium-server-standalone-3.141.59.jar -role webdriver -hub http://localhost:4444/grid/register -port 5556 -browser browserName=firefox > ./logs//node-firefox.log 2> ./logs//node-firefox-error.log & echo $! > ./pid/node-firefox.pid
                        echo "Starting Firefox Node"
                        java -jar selenium-server-standalone-3.141.59.jar -role webdriver -hub http://localhost:4444/grid/register -port 5558 -browser browserName=chrome > ./logs//node-chrome.log 2> ./logs//node-chrome-error.log & echo $! > ./pid/node-chrome.pid
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
                        kill -3 $PIDfox
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
                        kill -HUP `cat ./pid/grid.pid`
                        test -f ./pid/grid.pid && rm -f ./pid/grid.pid
                        sleep 1
                        java -jar selenium-server-standalone-3.141.59.jar -role hub > ./logs/grid.pid 2> ./logs/grid-error.log & echo $! > ./pid/grid.pid
                        echo "Reload Selenium Grid..."
                else
                        echo "Selenium Grid isn't running..."
                fi
                ;;
        *)      # no parameter specified
                echo "Usage: $SELF start|stop|restart|reload|force-reload|status"
                exit 1
        ;;
esac
