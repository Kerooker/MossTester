/*
 * Copyright 2019 Leonardo Colman Lopes
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import it.zielke.moji.SocketClient;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;
import java.util.Collection;

public class Main {

    public static void main(String[] args) throws Exception {
		// a list of students' source code files located in the prepared
		// directory.
		Collection<File> files = FileUtils.listFiles(new File(
			"C:\\Users\\Leonardo\\Desktop\\Mossw"), new String[] { "java" }, true);

		//get a new socket client to communicate with the Moss server
		//and set its parameters.
		SocketClient socketClient = new SocketClient();

		//set your Moss user ID
		socketClient.setUserID("346245933");
		//socketClient.setOpt...

		//set the programming language of all student source codes
		socketClient.setLanguage("java");

		//initialize connection and send parameters
		socketClient.run();

		//upload all source files of students
		for (File f : files) {
			socketClient.uploadFile(f);
		}

		//finished uploading, tell server to check files
		socketClient.sendQuery();

		//get URL with Moss results and do something with it
		URL results = socketClient.getResultURL();
		System.out.println("Results available at " + results.toString());
	}
}
