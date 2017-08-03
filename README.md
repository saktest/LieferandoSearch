1.	Download Eclipse and Java.
2.	In the Eclipse,add the cucumber plugin. From Help menu, click “Install New Software” and add new repository.http://cucumber.github.com/cucumber-eclipse/update-site
3.	Download the selenium java client http://docs.seleniumhq.org/download/ 
4.	Now Import the Maven project.
5.	Download geckodriver and chromedriver depending upon your OS for running the tests and change the path in the test.
6.	Download Firefox 46.
7.	Right click on the project and configure the build path in Eclipse.
8.	Under the Libraries, add all the external jars downloaded in Step2.
9.	Right click on feature file HomePage_Search.feature file to open with cucumber editor.
10.	Open the file TestRunner.java and Run as JUnit test.