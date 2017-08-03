1.	Download Eclipse and Java.
2.	In the Eclipse,add the cucumber plugin. From Help menu, click “Install New Software” and add new repository.http://cucumber.github.com/cucumber-eclipse/update-site
3.	Download the selenium java client http://docs.seleniumhq.org/download/ 
4.	On the command line, run the command “git clone https://github.com/saktest/LieferandoSearch.git”
5.	Now Import the Maven project.
6.	Download geckodriver and chromedriver depending upon your OS for running the tests and change the path in the test.
7.	Download Firefox 46.
8.	Right click on the project and configure the build path in Eclipse.
9.	Under the Libraries, add all the external jars downloaded in Step2.
10.	Right click on feature file HomePage_Search.feature file to open with cucumber editor.
11.	Open the file TestRunner.java and Run as JUnit test.