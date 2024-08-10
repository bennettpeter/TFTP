Build Instructions
------------------

Please make sure this machine has java environment by typing “java -version” in the terminal. (otherwise please install JDK).
sudo apt install default-jdk

run:
./build.sh

This creates TFTP.jar. Place TFTP.jar along with TFTPclient.sh and TFTPServer.sh in a directory on your path.

*************************
**How to use the Client**
*************************

Open terminal(or CMD), change path to a folder containing the files you want to send or the place you want received files
to be stored.

Commands: “TFTPClient.sh [host] [Request Type] [Filename] (mode)”. Mode can be blank, which means using default mode “octet”.

Download(read) file using octet mode: “TFTPClient.sh 127.0.0.1 R server1.jpg”
Download(read) file using ascii mode: “TFTPClient.sh 127.0.0.1 R server2.txt netascii”

Upload(write) file using octet mode: “TFTPClient.sh 127.0.0.1 W client1.jpg”
Upload(write) file using octet mode: “TFTPClient.sh 127.0.0.1 W client2.pdf”

-If upload or download successfully, the terminal will print the something like following:
—————————————
Downloading

Download Finished.
Filename: server2.txt
SHA1 Checksum: 3abbb1e4f8c6585d259d6a1a54e97fc1bd6f2b9a
—————————————

Please note that client is not allowed to upload files that are already exsited(has the same name) at server side. 

Files are stored in or read from the current directory of the client.

NOTE:
-Each transfer will allow up to 5 times of time out, after which the connection will be closed.
-Checksum of each file is provided after successfully transfer.
-File size is limited to 33554432 bytes by the protocol.

*************************
**How to run the Server**
*************************

Open terminal (or CMD), change path to a folder containing the files you want to send or the place you want received files.

Run the server using “sudo TFTPServer.sh”， then server will start and listen to port 69. Root is required to be permitted to listen on port 69.

Files are stored in or read from the current directory of the server.

-If upload or download successfully, the terminal will print the something like following:
—————————————
Read Request from /192.168.1.75
Transfer completed.(Client /192.168.1.75)
Filename: server2.txt
SHA1 checksum: 3abbb1e4f8c6585d259d6a1a54e97fc1bd6f2b9a
—————————————

Note:
-The server can support up to 2 clients at the same time. No guarantee if clients are more than 2.
-Checksum of each file is provided after successfully transfer.
-File size is limited to 33554432 bytes by the protocol.
