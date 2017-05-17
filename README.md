# SLO Chart - Alpha Leader

## 1. Description

Using flowcharts to introduce a dynamic and user friendly interface in order to optimize student class planning. Features will be more intuitive and numerous allowing for better schedule customization.



## 2.	List of features

### SLO Chart is improved by the following features:

- an elegant User Interface
- drag and drop classes from quarter to quarter
- mobile friendly page
- attach notes about classes
- support for prerequisites, minors, concentrations, grad students, and 4 + 1 "Blended" degree paths

## 3.	Requirements 

### SLO Chart solves 3 major problems. 

In descending importance, its UI is ugly, its UX is clunky, and it doesn't accommodate varying degree paths. The UI can be cleaned up by making the text larger for both desktop and mobile versions, adding color coding, and overall bringing it in to line with modern interactive web apps. The way the UX is designed means that users must start with no courses in the Poly Planner, and add every catalogCourse manually, through a clunky tool. 2.0 improves upon this by prepopulating the fields by adding a degree, and a max units per quarter field. If the sequence is not preferred, classes are dragged and dropped from quarter to quarter. Lastly, Poly Planner 2.0 allows the editting of degree plans to include minors, concentrations, master's degrees, and 4 + 1 "Blended" programs. When 2.0 accurately reflects the goals and pursuits of students, this gives students more flexibility and control.

## 4.	Architecture
Deployment Diagram V1.0
![](https://www.planttext.com/plantuml/img/IqaiIKnAB4vL2FRnT_Pm30g9Tm6ASENbfwGgE9QMPAJcbMGc9vRa5q64uAg2KulAKeku4fE1KWgbnK0cH460iq8rbuA20fYZ15VkM52Wf61ZarIKNmvKQsUdm5NB1TAbe5jQeAk0h8mBcQEWcvEQLgABvX9iAj0TXiR7K0Rs9Ognk4pY0W00)

## 5.	Technologies

- IDE: IntelliJ
- UML: Plant UML
- Version Control: github
- Project Management: Trello
- Prototyping: Invision
- Code Style Check: TravisCI
- Code Quality Check: SonarQube
- Team Chat: Slack

## 6.	Project Breakdown, Timeline and Milestones

### Format: Milestone - Estimated Date of Completion - Estimated Workload

- Define which features are required and optional - January 20 - Low
- Flowchart UI rough draft - January 25 - Medium
- Flowchart UML rough draft - February 1 - High
- Requirements document - February 15 - High
- Class list for major- February 8 - Medium
- Drag and drop class functionality - Next Quarter - Medium
- Minor and concentration implementation - Next Quarter - Low
- Prototype Flowchart - March 15 - Medium
- Customized notes on classes - Next Quarter - Low
- Prerequisites requirement - Next Quarter - High
- Mobile friendly implementation - Next Quarter - High

## 7.	Risks and Uncertainties

One uncertainty is what access to Cal Poly's API we will have access to, and therefore how easy it will be to get information on classes required for majors, prerequisites, etc.  Another uncertainty is how fleshed-out we will be able to make the mobile version, if we mostly focus on the desktop version.  Furthermore, since we are planning on introducing a not insignificant amount of new features, a risk is that we will not be able to complete everything in the time that we have.

## 8. Implementation of DevOPs

We integrated TravisCI in order to automate our testing during our commits into github. We are hoping that this application of Travis CI will help our developer team catch more bugs and errors in code so that our developing process can be faster. In addition to Travis CI, our code quality will be checked using SonarQube. SonarQube is an open source platform for continuous code quality. 
