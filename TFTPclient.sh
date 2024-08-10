#!/bin/bash
# Run TFTP Server

scriptname=`readlink -e "$0"`
scriptpath=`dirname "$scriptname"`
scriptname=`basename "$scriptname" .sh`

java -cp "$scriptname/TFTP.jar" org.mythtv.TFTP.TFTPClient "$@"