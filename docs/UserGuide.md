---
layout: page
toc: true
title: npc_track User Guide
---

![Ui](images/ug-image.png)

### Making student tracking easy.

`npc_track` is the application for all teaching assistants, streamlining student management processes to help combat the tediousness of keeping track of
student particulars and performance.

Here’s an overview of how `npc_track` can help you streamline your student management process:
- Manage your student contacts (with working Telegram links!)
- Manage tutorial groups!
- Keep track of their attendance and participation levels.
- Keep track of their grades!

But more than that, the application is *simple to use* and efficient. The application has a command line interface (CLI) in which you can type in commands without having to scroll through contacts and lists to click on buttons. The application sports a simple and very readable look!

### How can `npc_track` help you in your teaching journey?

***`npc_track` is for all TA’s, and is adaptable for their management and organisational styles!***

We help teaching assistants to be able to bring together their teaching needs in a hassle-free manner. For instance,
adding extra information for a student named Ted can easily be done using the various keyword features as listed in
our [Features Section](#features)

`npc_track` saves teaching assistant from having to spend so much precious time by reducing the complexity and the
need to
navigate different platforms just to search their students. Now, it can be done in a one-stop manner using `npc_track`

Not ready to use `npc_track`? Fret Not, you can jump to the [Quick Start](#quick-start) section to begin your
`npc_track`
journey

If you have used `npc_track` before, you can proceed to the relevant sections via our [Table of Contents](#toc) on
the sidebar


### How can this guide help me?

**First time user?** Welcome and thank you for using our app! Check out the installation guide [here](#quick-start)!

Once you’re done setting up, check out the [features](#features) of `npc_track` to manage the your students' info!

If you are an intermediary user and are confused or unclear of some of our features, check out the [FAQ](#FAQ) as well!

Encountered some bugs or unexpected events when using the app? Maybe [Known Issues](#issues) will give you some guidance on what the known bugs (and their status) are!

Need help on memorizing commands? Drop by in [Command summary](#summary)!


---

<a name="toc"></a>
## Table of Contents

{:toc}

- [Features](#features)

  - [Viewing Help](#help) `help`

  - [Adding a Student](#add) `add`

  - [Editing a Student](#edit) `edit`

  - [Deleting a Student](#delete) `delete`

  - [Listing All Students](#list) `list`

  - [Finding a Student](#find) `find`

  - [Finding a Group of Students](#findGroup) `findGroup`

  - [Distributing Assignments](#assign) `assign`

  - [Distributing Assignments to a Group of Students](#assignGroup) `assignGroup`

  - [Distributing Assignments to an individual](#assignIndiv) `assignIndiv`

  - [Distributing Assignments](#deassign) `deassign`

  - [Grading a Student](#grade) `grade`

  - [Grading a Group of Students](#gradeGroup) `gradeGroup`

  - [Marking Attendance](#markAtd) `markAtd`

  - [Unmarking Attendance](#unmarkAtd) `unmarkAtd`

  - [Marking Attendance for a Group of Students](#markGroupAtd) `markGroupAtd`

  - [Unmarking Attendance for a Group of Students](#unmarkGroupAtd) `unmarkGroupAtd`

  - [Exiting the Program](#exit)


- [FAQ](#FAQ)

- [Known Issues](#issues)

- [Command Summary](#summary)

<a name="quick-start"></a>
## Quick start

Step 1 : Ensure you have downloaded Java version 11 or above in your computer. Here are the steps on how to download [Java](https://www.oracle.com/java/technologies/downloads/#java11).

Step 2 : Navigate to our [website](https://github.com/AY2324S1-CS2103T-T12-1/tp/releases/tag/v1.3.trial) and download the latest JAR file.
![Step 2](images/download1.png)

Step 3 : Save the [JAR](#glossary) file to the folder where you want to locate the file. Right click and copy the 
path of where the file is located.
![Step 3](images/download2.png)

The following steps will be illustrated with **Windows**.
However, the process is the same for **Mac** and **Linux**.

Step 4 : Open your computer's terminal. 
![Step 4](images/download3.png)

Step 5 : Type in `cd` followed by the location of the file you copied in step 3. Remove the `""` (double quotes) and 
the file name as shown in the figure.  
![Step 5](images/download4.png)

Step 6 : Type the command `java -jar npctrack.jar` to run the app.
![Step 6](images/download5.png)

---

<a name="parameter"></a>
## Common Parameters

| Parameters | Description     | Constraints                                                                                                                                                       | Valid Examples                  | Invalid Examples             |
|------------|-----------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------|------------------------------|
| `n/`       | Names           | Must be alphanumeric and can contain spaces                                    <br/><br/>                                                                         | John Doe                        | $5money                      |
| `a/`       | Telegram handle | Must be a-z, 0-9 or underscore. <br/> Minimum Length is 5 characters and maximum 32 characters <br/> Cannot end with an underscore <br/> Must start with a letter | harukaNaruto, loli_pop, l0l1pop | $telegram, _tele, 56thperson |
| `group/`   | Group names     | Must be alphanumeric and cannot contain spaces                                    <br/><br/>                                                                      | group1, T01, LEC1               | $group, _grp, group 1        |


--------------------------------------------------------------------------------------------------------------------

<a name="features"></a>
## Features
<div markdown="block" class="alert alert-info">

**:information_source: How to read our commands:**<br>

* Words in `UPPER_CASE` are the details to be given by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a detail which can be used as `add n/John Doe`.

* Details in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Items with `…`​ after them can be used multiple times or none at all.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/friend`, `t/friend t/family` etc.

* Details can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
</div>

<a name="help"></a>
### Viewing help : `help`

If you have trouble using `npc_track`, simply type the `help` command. The user guide opens in the browser.

<div markdown="span" class="alert alert-success">
:pencil2: **Purpose:**
Helps user navigate through the app.
<br><br>
***Format***: `help`
</div>

<div markdown="span" class="alert alert-warning">:pushpin: **Having Problems?**
Do not worry! You can refer to our [troubleshooting](#issues) guide for common problems. 
***Confused with some terms?*** You can refer to our [glossary](#glossary) to find out.

</div>

:top: [Back to Table Of Contents](#toc)

<a name="add"></a>
### Adding a student: `add`

Want to add a student into your student contacts? Give the `add` command a try!

<div markdown="span" class="alert alert-success">
:pencil2: **Purpose:**
Adds a student to the student book.
<br><br>
***Format***: `add n/NAME [p/PHONE_NUMBER] [e/EMAIL] [a/TELEGRAM_HANDLE] [t/TAG]… [c/COMMENT]… [group/GROUP]`
</div>

<div markdown="span" class="alert alert-primary">:bulb: **Extra Information**
<br><br>
- A student can have any number of optional tags
<br>
- A student can have any number of optional comments
<br>
- Cannot add a student with the same name in the list.
</div>

<div markdown="span" class="alert alert-warning">:pushpin: **Having Problems?**
Do not worry! You can refer to our [troubleshooting](#issues) guide for common problems. 
***Confused with some terms?*** You can refer to our [glossary](#glossary) to find out.
</div>


| Examples                                                                                     | Purpose                                                                                      |
|----------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------|
| `add n/John Doe p/98765432 e/johnd@example.com a/johnTelegram`                               | Adds John Doe (Telegram : @johnTelegram) with additional details like phone number and email |
| `add n/Betsy Crowe e/betsycrowe@example.com a/newTelegram p/91234567 t/CS2103T c/Quiet Student` | Adds Betsy Crowe <br/>(Telegram : @newTelegram) with extra comments and tags                 |
| `add n/James group/tut4`                                                                     | Adds James while grouping him to `tut4`                                                      |
| `add n/Benson`                                                                               | Adds Benson only                                                                             |

:top: [Back to Table Of Contents](#toc)

<a name="list"></a>
### Listing all students : `list`

Want to see all your students' details? Simply type in the one-word `list` command.

<div markdown="span" class="alert alert-success">
:pencil2: **Purpose:**
Shows a list of all students.
<br><br>
***Format***: `list`
</div>

<div markdown="span" class="alert alert-warning">:pushpin: **Having Problems?**
Do not worry! You can refer to our [troubleshooting](#issues) guide for common problems. 
***Confused with some terms?*** You can refer to our [glossary](#glossary) to find out.
</div>

:top: [Back to Table Of Contents](#toc)

<a name="find"></a>
### Finding students : `find`

Finding it difficult to scroll through the whole list of students? Don't worry just find the specific student using
the `find` command.

<div markdown="span" class="alert alert-success">
:pencil2: **Purpose:**
Finds students associated with the keyword.
<br><br>
***Format***: `find KEYWORD [MORE_KEYWORDS]…`
</div>


<div markdown="span" class="alert alert-primary">:bulb: **Extra Information**
<br><br>
- `KEYWORD` : Case insensitive and can involve any character. 
</div>

<div markdown="span" class="alert alert-warning">:pushpin: **Having Problems?**
Do not worry! You can refer to our [troubleshooting](#issues) guide for common problems. 
***Confused with some terms?*** You can refer to our [glossary](#glossary) to find out.
</div>

| Examples          | Purpose                             |
|-------------------|-------------------------------------|
| `find James Jake` | Finds a student called "James Jake" |

:top: [Back to Table Of Contents](#toc)

### Finding students by group : `findGroup`

Finding it difficult to scroll through the whole list of students? Don't worry just find the specific student using
the `findGroup` command.

<div markdown="span" class="alert alert-success">
:pencil2: **Purpose:**
Finds students associated with the group.
<br><br>
***Format***: `findGroup KEYWORD [MORE_KEYWORDS]...`
</div>

<div markdown="span" class="alert alert-primary">:bulb: **Extra Information**
<br><br>
- `KEYWORD` : Case insensitive and can involve any character. 
</div>

<div markdown="span" class="alert alert-warning">:pushpin: **Having Problems?**
Do not worry! You can refer to our [troubleshooting](#issues) guide for common problems.
***Confused with some terms?*** You can refer to our [glossary](#glossary) to find out.
</div>

| Examples      | Purpose                                       |
|---------------|-----------------------------------------------|
| `findGroup 1` | Finds a student in group 1 and lists them out |

:top: [Back to Table Of Contents](#toc)

<a name="edit"></a>
### Editing a person : `edit`

Have anything you want to change ? Not to worry, your student details is editable.

<div markdown="span" class="alert alert-success">
:pencil2: **Purpose:**
Edits an existing student.
<br><br>
***Format***: `edit INDEX [n/NAME] [p/PHONE] [e/EMAIL] [t/TAG]… [c/COMMENT]… [a/TELEGRAM_HANDLE] [group/GROUP]`
</div>

<div markdown="span" class="alert alert-warning">:pushpin: **Having Problems?**
Do not worry! You can refer to our [troubleshooting](#issues) guide for common problems. 
***Confused with some terms?*** You can refer to our [glossary](#glossary) to find out.
</div>

| Examples                                  | Purpose                                                                                                             |
|-------------------------------------------|---------------------------------------------------------------------------------------------------------------------|
| `edit 1 p/91234567 e/johndoe@example.com` | Edits the phone number and email address of the 1st person to be `91234567` and `johndoe@example.com` respectively. |
| `edit 2 n/Betsy Crower t/`                | Edits the name of the 2nd person to be `Betsy Crower` and clears all existing tags.                                 |
| `edit 3 t/ c/Loves cake`                  | Clears all existing tags of the 3rd person and replaces their tags with "Loves cake".                               |
| `edit 4 group/2`                          | Moves the 4th person to group 2.                                                                                    |

:top: [Back to Table Of Contents](#toc)

### Attendance

For managing attendance, the following commands are available:
* markAtd
* unmarkAtd

<a name="markAtd"></a>
#### Mark Attendance : `markAtd`

Want to mark a student's attendance? Use the `markAtd` command.

<div markdown="span" class="alert alert-success">
:pencil2: **Purpose:**
Marks the attendance of a student for that tutorial.
<br><br>

***Format***: `markAtd INDEX t/TUTORIAL s/STATUS`

</div>

<div markdown="span" class="alert alert-primary">:bulb: **Extra Information**
<br><br>
- `INDEX`: A positive integer representing the index of the student as shown in the list.
<br>
- `TUTORIAL`: An integer between 1 and 12 (inclusive)
<br>
- Marking the attendance for a week that is already marked will result in the message
`This week's attendance has already been marked!`. In addition, the attendance status
list will be updated.
</div>

`STATUS`: The student's attendance status (case sensitive). Valid attendance statuses are as follows:

| Status | Meaning                                                       |
|--------|---------------------------------------------------------------|
| **P**  | Present - If the student shows up for the tutorial.           |
| **A**  | Absent - If the student is absent with no valid reason given. |
| **VR** | VR - If the student is absent with a valid reason (e.g. MC).  |

<div markdown="span" class="alert alert-warning">:pushpin: **Having Problems?**
Do not worry! You can refer to our [troubleshooting](#issues) guide for common problems. 
***Confused with some terms?*** You can refer to our [glossary](#glossary) to find out.
</div>

| Examples              | Purpose                                                                      |
|-----------------------|------------------------------------------------------------------------------|
| `markAtd 1 t/1 s/P`   | Marks attendance of student with index 1 and "PRESENT" status for tutorial 1 |
| `markAtd 2 t/12 s/VR` | Marks attendance of student with index 2 and "VALID REASON" for tutorial 12  |

:top: [Back to Table Of Contents](#toc)

<a name="unmarkAtd"></a>
#### Unmark Attendance : `unmarkAtd`

Want to unmark a student's attendance? Use the `unmarkAtd` command.

<div markdown="span" class="alert alert-success">
:pencil2: **Purpose:**
Unmark the attendance of a student for that tutorial.
<br><br>

***Format***: `unmarkAtd INDEX t/TUTORIAL`

</div>

<div markdown="span" class="alert alert-primary">:bulb: **Extra Information**
<br><br>
- `INDEX`: A positive integer representing the index of the student as shown in the list.
<br>
- `TUTORIAL`: An integer between 1 and 12 (inclusive)
<br>
- Unmarking the attendance for a week that is already unmarked will result in the message
`This week's attendance has already been unmarked!`

</div>

<div markdown="span" class="alert alert-warning">:pushpin: **Having Problems?**
Do not worry! You can refer to our [troubleshooting](#issues) guide for common problems. 
***Confused with some terms?*** You can refer to our [glossary](#glossary) to find out.
</div>

| Examples           | Purpose                                                    |
|--------------------|------------------------------------------------------------|
| `unmarkAtd 1 t/1`  | Unmark attendance of student with index 1 for tutorial 1)  |
| `unmarkAtd 2 t/12` | Unmark attendance of student with index 2 for tutorial 12) |

:top: [Back to Table Of Contents](#toc)

<a name="markGroupAtd"></a>
#### Mark Group Attendance: `markGroupAtd`

Want to mark a student's group for their attendance? Use the `markGroupAtd` command.

<div markdown="span" class="alert alert-success">
:pencil2: **Purpose:**
Marks the attendance of a group of students for that tutorial.
<br><br>

***Format***: `markGroupAtd GROUP t/TUTORIAL s/STATUS`

</div>

<div markdown="span" class="alert alert-primary">:bulb: **Extra Information**
<br><br>
- `GROUP`: A string representing the group of students as shown in the list.
<br>
- `TUTORIAL`: An integer between 1 and 12 (inclusive)
<br>
- Marking the attendance for a week that is already marked will result in the message
`This week's attendance has already been marked!`

</div>

`STATUS`: The student's attendance status (case sensitive). Valid attendance statuses are as follows:

| Status | Meaning                                                       |
|--------|---------------------------------------------------------------|
| **P**  | Present - If the student shows up for the tutorial.           |
| **A**  | Absent - If the student is absent with no valid reason given. |
| **VR** | VR - If the student is absent with a valid reason (e.g. MC).  |

<div markdown="span" class="alert alert-warning">:pushpin: **Having Problems?**
Do not worry! You can refer to our [troubleshooting](#issues) guide for common problems. 
***Confused with some terms?*** You can refer to our [glossary](#glossary) to find out.
</div>

| Examples                 | Purpose                                                               |
|--------------------------|-----------------------------------------------------------------------|
| `markGroupAtd 1 t/1 s/P` | marks attendance of students in group 1 for tutorial 1 as all present |

:top: [Back to Table Of Contents](#toc)

<a name="unmarkGroupAtd"></a>
#### Unmark Group Attendance: `unmarkGroupAtd`

Want to unmark a student's group for their attendance? Use the `unmarkGroupAtd` command.

<div markdown="span" class="alert alert-success">
:pencil2: **Purpose:**
Unmark the attendance of a group of students for that tutorial.
<br><br>

***Format***: `unmarkGroupAtd GROUP t/TUTORIAL`

</div>

<div markdown="span" class="alert alert-primary">:bulb: **Extra Information**
<br><br>
- `GROUP`: A string representing the group of students as shown in the list.
<br>
- `TUTORIAL`: An integer between 1 and 12 (inclusive)
<br>
- Unmarking the attendance for a week that is already unmarked will result in the message
`This week's attendance has already been unmarked!`

</div>

<div markdown="span" class="alert alert-warning">:pushpin: **Having Problems?**
Do not worry! You can refer to our [troubleshooting](#issues) guide for common problems. 
***Confused with some terms?*** You can refer to our [glossary](#glossary) to find out.
</div>

| Examples               | Purpose                                                  |
|------------------------|----------------------------------------------------------|
| `unmarkGroupAtd 1 t/1` | Unmark attendance of students in group 1 for tutorial 1) |

:top: [Back to Table Of Contents](#toc)

### Participation

For participation, you can make the following commands:
* inputPP
* inputGroupPP
* listParticipation

#### Insert participation points to a student: `inputPP`
<a name="inputPP"></a>

Want to reward your student groups with points for their diligent participation? Use the `inputGroupPP` command.

<div markdown="span" class="alert alert-success">
:pencil2: **Purpose:**
Input participation points for a student for that tutorial.
<br><br>

***Format***:  `inputPP INDEX t/TUTORIAL pp/POINTS`

</div>

<div markdown="span" class="alert alert-primary">:bulb: **Extra Information**
<br><br>
- `INDEX`: A positive integer representing the index of the student as shown in the list.
<br>
- `TUTORIAL`: An integer between 1 and 12 (inclusive)
<br>
- `POINTS`: An integer between 0 and 1000 (inclusive)
<br>
- Participation points can only be inputted for a tutorial that is already marked as attended.
  Else, it will result in the message `Before inputting participation points,
  mark the attendance of the student first!`

</div>

<div markdown="span" class="alert alert-warning">:pushpin: **Having Problems?**
Do not worry! You can refer to our [troubleshooting](#issues) guide for common problems. 
***Confused with some terms?*** You can refer to our [glossary](#glossary) to find out.
</div>

| Examples                | Purpose                                                                 |
|-------------------------|-------------------------------------------------------------------------|
| `inputPP 1 t/1 pp/350`  | For student with index 1, input 350 participation points to tutorial 1  |
| `inputPP 2 t/12 pp/500` | For student with index 2, input 500 participation points to tutorial 12 |

:top: [Back to Table Of Contents](#toc)

<a name="inputGroupPP"></a>
#### Insert participation points to a group of students: `inputGroupPP`

Want to reward your student groups with points for their diligent participation? Use the `inputGroupPP` command.

<div markdown="span" class="alert alert-success">
:pencil2: **Purpose:**
Input participation points for a group of students for that tutorial.
<br><br>

***Format***: `inputGroupPP GROUP t/TUTORIAL pp/POINTS`

</div>

<div markdown="span" class="alert alert-primary">:bulb: **Extra Information**
<br><br>
- `GROUP`: The tutorial group name of the students as shown in the list.
<br>
- `TUTORIAL`: An integer between 1 and 12 (inclusive)
<br>
- `POINTS`: An integer between 0 and 1000 (inclusive)
<br>
- Participation points can only be inputted for a tutorial that is already marked as attended.
  Else, the student(s) with unmarked attendance will not receive the any participation points.

</div>

<div markdown="span" class="alert alert-warning">:pushpin: **Having Problems?**
Do not worry! You can refer to our [troubleshooting](#issues) guide for common problems. 
***Confused with some terms?*** You can refer to our [glossary](#glossary) to find out.
</div>

| Examples                         | Purpose                                                             |
|----------------------------------|---------------------------------------------------------------------|
| `inputGroupPP lab33 t/1 pp/350`  | For students of lab33, input 350 participation points to tutorial 1 |
| `inputGroupPP tut39 t/12 pp/500` | For student of tut39, input 500 participation points to tutorial 12 |

:top: [Back to Table Of Contents](#toc)

<a name="listParticipation"></a>
#### List participation records: `listParticipation`

Want to check your student's participation details? Not to worry, you can use our `listParticipation` command.

<div markdown="span" class="alert alert-success">
:pencil2: **Purpose:**
List a student's participation record.
<br><br>

***Format***: `listParticipation INDEX`
</div>

<div markdown="span" class="alert alert-primary">:bulb: **Extra Information**
<br><br>
- `INDEX`: A positive integer representing the index of the student as shown in the list.
</div>

<div markdown="span" class="alert alert-warning">:pushpin: **Having Problems?**
Do not worry! You can refer to our [troubleshooting](#issues) guide for common problems. 
***Confused with some terms?*** You can refer to our [glossary](#glossary) to find out.
</div>

| Examples              | Purpose                                                    |
|-----------------------|------------------------------------------------------------|
| `listParticipation 1` | List the participation record for the student with index 1 |
| `listParticipation 5` | List the participation record for the student with index 5 |

### Assignments

For allocating and grading assignments , you can make the following commands:
* assign
* deassign
* deassignIndiv
* assignGroup
* assignIndiv
* grade
* gradeGroup

<a name="assign"></a>
#### Distribute assignments: `assign`

Keen to assign just all students with a particular assignment? You can use the `assign` command to do that!

<div markdown="span" class="alert alert-success">
:pencil2: **Purpose:**
Create an assignment and assign it to all students.
<br><br>

***Format***: `assign n/ASSIGNMENT_NAME m/MAX_SCORE`
</div>

<div markdown="span" class="alert alert-primary">:bulb: **Extra Information**
<br><br>
- `MAX_SCORE`: An integer between 1 and 1000.
<br>
- If the student already has the assignment, assigning the same assignment will overwrite the current assignment.
<br>
- `ASSIGNMENT_NAME`: Case sensitive. For example, 'Tutorial 1' and 'tutorial 1' are two different assignments.
</div>

<div markdown="span" class="alert alert-warning">:pushpin: **Having Problems?**
Do not worry! You can refer to our [troubleshooting](#issues) guide for common problems. 
***Confused with some terms?*** You can refer to our [glossary](#glossary) to find out.
</div>

| Examples                   | Purpose                                                                                         |
|----------------------------|-------------------------------------------------------------------------------------------------|
| `assign n/Tutorial1 m/100` | Assigns every student in the list with an assignment called Tutorial1 and maximum score is 100. |

:top: [Back to Table Of Contents](#toc)

<a name="deassign"></a>
#### Deassign Assignments: `deassign`

Did you accidentally assign the wrong assignment or just want to change the assignment? You can now
do it using the `deassign` command.

<div markdown="span" class="alert alert-success">
:pencil2: **Purpose:**
Delete an assignment for all students.
<br><br>

***Format***: `deassign n/ASSIGNMENT_NAME`
</div>

<div markdown="span" class="alert alert-primary">:bulb: **Extra Information**
<br><br>
- `ASSIGNMENT_NAME`: Case sensitive. For example, 'Tutorial 1' and 'tutorial 1' are two different assignments.
</div>

<div markdown="span" class="alert alert-warning">:pushpin: **Having Problems?**
Do not worry! You can refer to our [troubleshooting](#issues) guide for common problems.
***Confused with some terms?*** You can refer to our [glossary](#glossary) to find out.
</div>

| Examples      | Purpose                                                                        |
|---------------|--------------------------------------------------------------------------------|
| `deassign n/Tutorial1` | Deletes the assignment called Tutorial1 for all students with that assignment. |

:top: [Back to Table Of Contents](#toc)

<a name="deassignIndiv"></a>
#### Deassign Individual Assignments: `deassignIndiv`

Did you accidentally assign a student with the wrong assignment or just want to change the assignment? You can now
do it using the `deassignIndiv` command

<div markdown="span" class="alert alert-success">
:pencil2: **Purpose:**
Delete an assignment for a particular student.
<br><br>

***Format***: `deassignIndiv INDEX n/ASSIGNMENT_NAME`
</div>

<div markdown="span" class="alert alert-primary">:bulb: **Extra Information**
<br><br>
- `ASSIGNMENT_NAME`: Case sensitive. For example, 'Tutorial 1' and 'tutorial 1' are two different assignments.
</div>

<div markdown="span" class="alert alert-warning">:pushpin: **Having Problems?**
Do not worry! You can refer to our [troubleshooting](#issues) guide for common problems.
***Confused with some terms?*** You can refer to our [glossary](#glossary) to find out.
</div>

| Examples                      | Purpose                                                          |
|-------------------------------|------------------------------------------------------------------|
| `deassignIndiv 1 n/Tutorial1` | Deletes the assignment called Tutorial1 for student with index 1 |

:top: [Back to Table Of Contents](#toc)

<a name="assignGroup"></a>
#### Distribute assignments to a group of students: `assignGroup`

Keen to assign just a group of students with a particular assignment? You can use the `assignGroup` command to do that!

<div markdown="span" class="alert alert-success">
:pencil2: **Purpose:**
Create an assignment and assign it to a group of students.
<br><br>
***Format***: `assignGroup GROUP n/ASSIGNMENT_NAME m/MAX_SCORE`
</div>

<div markdown="span" class="alert alert-primary">:bulb: **Extra Information**
<br><br>
- `MAX_SCORE`: An integer between 1 and 1000.
<br>
- If the student already has the assignment, assigning the same assignment will overwrite the current assignment.
<br>
- `ASSIGNMENT_NAME`: Case sensitive. For example, 'Tutorial 1' and 'tutorial 1' are two different assignments.
</div>

<div markdown="span" class="alert alert-warning">:pushpin: **Having Problems?**
Do not worry! You can refer to our [troubleshooting](#issues) guide for common problems. 
***Confused with some terms?*** You can refer to our [glossary](#glossary) to find out.
</div>

| Examples                           | Purpose                                                                                |
|------------------------------------|----------------------------------------------------------------------------------------|
| `assignGroup 1 n/Tutorial1 m/100`  | Assigns group named "1" with an assignment called Tutorial1 and maximum score is 100.  |
| `assignGroup Pheonix n/Lab1 m/100` | Assigns group named "Pheonix" with an assignment called Lab1 and maximum score is 100. |

:top: [Back to Table Of Contents](#toc)

<a name="assignIndiv"></a>
#### Distribute assignments to a student: `assignIndiv`

Keen to assign just one student with a particular assignment? You can use the `assignIndiv` command to do that!

<div markdown="span" class="alert alert-success">
:pencil2: **Purpose:**
Create an assignment and assign it to a student.
<br><br>
***Format***: `assignIndiv INDEX n/ASSIGNMENT_NAME m/MAX_SCORE`
</div>

<div markdown="span" class="alert alert-primary">:bulb: **Extra Information**
<br><br>
- `MAX_SCORE`: An integer between 1 and 1000.
<br>
- If the student already has the assignment, assigning the same assignment will overwrite the current assignment.
<br>
- `ASSIGNMENT_NAME`: Case sensitive. For example, 'Tutorial 1' and 'tutorial 1' are two different assignments.
</div>

<div markdown="span" class="alert alert-warning">:pushpin: **Having Problems?**
Do not worry! You can refer to our [troubleshooting](#issues) guide for common problems. 
***Confused with some terms?*** You can refer to our [glossary](#glossary) to find out.
</div>

| Examples                          | Purpose                                                                          |
|-----------------------------------|----------------------------------------------------------------------------------|
| `assignIndiv 1 n/Tutorial1 m/100` | Assigns student #1 with an assignment called Tutorial1 and maximum score is 100. |
| `assignIndiv 10 n/Lab1 m/100`     | Assigns student #10 with an assignment called Lab1 and maximum score is 100.     |

:top: [Back to Table Of Contents](#toc)

<a name="grade"></a>
#### Grade assignments: `grade`

Need to give grades to the assignments? You can use our `grade` command to do that.
![Grade](images/grade.png)

<div markdown="span" class="alert alert-success">
:pencil2: **Purpose:**
Grade a student's assignment.
<br><br>
***Format***: `grade INDEX n/ASSIGNMENT_NAME g/SCORE`
</div>

<div markdown="span" class="alert alert-primary">:bulb: **Extra Information**
<br><br>
- A student's marks need to be between 0 (inclusive) and the maximum score of the assignment (inclusive).
<br>
- Need to specify the index of the student after the command word.
<br>
- `-0` is considered to be 0 in the system. 
<br>
- `ASSIGNMENT_NAME`: Case sensitive. For example, 'Tutorial 1' and 'tutorial 1' are two different assignments.
</div>

<div markdown="span" class="alert alert-warning">:pushpin: **Having Problems?**
Do not worry! You can refer to our [troubleshooting](#issues) guide for common problems. 
***Confused with some terms?*** You can refer to our [glossary](#glossary) to find out.
</div>

| Examples                   | Purpose                                            |
|----------------------------|----------------------------------------------------|
| `grade 1 n/tutorial2 g/80` | Grades student #1 a score of 80 for his tutorial2. |
| `grade 10 n/lab2 g/35`     | Grades student #10 a score of 35 for his lab2.     |

:top: [Back to Table Of Contents](#toc)

<a name="gradeGroup"></a>
### Grade assignments for a group of students: `gradeGroup`

Sounds tedious to grade the students individually. Try the `gradeGroup` command to collectively grade students in a 
group.

<div markdown="span" class="alert alert-success">
:pencil2: **Purpose:**
Grade a group of students' assignment.
<br><br>
***Format***: `gradeGroup GROUP n/ASSIGNMENT_NAME g/SCORE`
</div>

<div markdown="span" class="alert alert-primary">:bulb: **Extra Information**
<br><br>
- A student's marks need to be between 0 (inclusive) and the maximum score of the assignment (inclusive).
<br>
- Need to specify the name of the group after the command.
<br>
- `-0` is considered to be 0 in the system. 
<br>
- Every student in the group must have the assignment. This command pairs well with `assignGroup`!
<br>
- `ASSIGNMENT_NAME`: Case sensitive. For example, 'Tutorial 1' and 'tutorial 1' are two different assignments.
</div>

<div markdown="span" class="alert alert-warning">:pushpin: **Having Problems?**
Do not worry! You can refer to our [troubleshooting](#issues) guide for common problems. 
***Confused with some terms?*** You can refer to our [glossary](#glossary) to find out.
</div>

| Examples                              | Purpose                                                                                |
|---------------------------------------|----------------------------------------------------------------------------------------|
| `gradeGroup Class33 n/Tutorial1 g/90` | Grades students in group `Class33` for an assignment called `Tutorial1` a score of 90. |

:top: [Back to Table Of Contents](#toc)

<a name="group"></a>
### Grouping students: `group`

If you ever encounter changing group names, you can always use our `group` command to do that.

<div markdown="span" class="alert alert-success">
:pencil2: **Purpose:**
Change the student group names.
<br><br>
***Format***: `group PREV_GROUP UPDATED_GROUP`
</div>

<div markdown="span" class="alert alert-primary">:bulb: **Extra Information**
<br><br>
- Student group names must be alphanumeric and **cannot** contain spaces.
</div>

<div markdown="span" class="alert alert-warning">:pushpin: **Having Problems?**
Do not worry! You can refer to our [troubleshooting](#issues) guide for common problems. 
***Confused with some terms?*** You can refer to our [glossary](#glossary) to find out.
</div>

| Examples        | Purpose                            |
|-----------------|------------------------------------|
| `group T01 T02` | Change the group name of `T01` to `T02`. |

:top: [Back to Table Of Contents](#toc)

<a name="delete"></a>
### Deleting a student : `delete`

Want to remove a student? Use the `delete` command.

<div markdown="span" class="alert alert-success">
:pencil2: **Purpose:**
Deletes the specified person from the student book.
<br><br>
***Format***: `delete INDEX`
</div>

<div markdown="span" class="alert alert-primary">:bulb: **Extra Information**
<br><br>
- `INDEX` must be a valid index. 
</div>

<div markdown="span" class="alert alert-warning">:pushpin: **Having Problems?**
Do not worry! You can refer to our [troubleshooting](#issues) guide for common problems. 
***Confused with some terms?*** You can refer to our [glossary](#glossary) to find out.
</div>

:top: [Back to Table Of Contents](#toc)

<a name="exit"></a>
### Exiting the program : `exit`

Are you done using `npc_track` and want to terminate the program. Just type the `exit` command to do that.

<div markdown="span" class="alert alert-success">
:pencil2: **Purpose:**
Exits the program.
<br><br>
***Format***: `exit`
</div>

<div markdown="span" class="alert alert-warning">:pushpin: **Having Problems?**
Do not worry! You can refer to our [troubleshooting](#issues) guide for common problems. 
***Confused with some terms?*** You can refer to our [glossary](#glossary) to find out.
</div>

### Clearing the Data : `clear`

Do you need to remove all data in your `npc_track`. You can always do it in a very simple way using the `clear` command.

<div markdown="span" class="alert alert-success">
:pencil2: **Purpose:**
Clear `npc_track` data.
<br><br>
***Format***: `clear`
</div>

<div markdown="span" class="alert alert-danger">:exclamation: **Caution:**
Clearing the data will remove all information. Hence, it is recommended to make a backup of the file before clearing 
it. Hence, since this is a irreversible command, type `yes` to confirm the action of wiping the data.
![Clear](images/clear.png)
</div>

<div markdown="span" class="alert alert-warning">:pushpin: **Having Problems?**
Do not worry! You can refer to our [troubleshooting](#issues) guide for common problems. 
***Confused with some terms?*** You can refer to our [glossary](#glossary) to find out.
</div>

### Saving the data

StudentBook data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

`npc_track` data are saved automatically as a JSON file. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, StudentBook will discard all data and start with an empty data file at the next run. Hence, it is recommended to make a backup of the file before editing it.
</div>

### Archiving data files `[coming in v2.0]`

_Details coming soon ..._

--------------------------------------------------------------------------------------------------------------------

## Troubleshooting
<a name="issues"></a>

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.

--------------------------------------------------------------------------------------------------------------------
<a name="gui"></a>
## Navigating `npc_track`

### GUI Interface
Our user-friendly interface allows quick navigation for teaching assistants. Below is an overview of the interface
followed by a quick summary guide of the Graphical User Interface (GUI)

![Ui](images/npctrack-guide.png)

| Component               | Function                                                                                           |
|-------------------------|----------------------------------------------------------------------------------------------------|
| **Command Result**      | The result of the commands that user types in the command box                                      |
| **Command Box**         | A placeholder for users to type the various command as listed in the [Features](#features) section |
| **Student Information** | A display of the different information regarding the student                                       |
| **Student Index**       | The `INDEX` of the student that users want to change / view                                        |

--------------------------
<a name="summary"></a>
## Command summary

| Action                                | Format, Examples                                                                                                                                                                                                              |
|---------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Add**                               | `add n/NAME p/[PHONE_NUMBER] e/[EMAIL] a/[TELEGRAM_HANDLE] [t/TAG]… [c/COMMENT]… [group/GROUP]` <br> e.g., `add n/James Ho p/92224444 e/jamesho@example.com a/jamesTele t/CS2103T t/CS2103R c/Owes an assignment group/tut33` |
| **Clear**                             | `clear​`                                                                                                                                                                                                                      |
| **Confirm Clear**                     | `yes`                                                                                                                                                                                                                         |
| **Deassign Assignments**              | `deassign n/ASSIGNMENT_NAME`                                                                                                                                                                                                  |
| **Deassign Individual Assignments**   | `deassigIndiv INDEX​ n/ASSIGNMENT_NAME`                                                                                                                                                                                       |
| **Delete**                            | `delete INDEX​` <br> e.g., `delete 3`                                                                                                                                                                                         |
| **Distribute Assignments**            | `assign n/ASSIGNMENT_NAME m/MAX_SCORE`                                                                                                                                                                                        |
| **Distribute Group Assignments**      | `assignGroup GROUP n/ASSIGNMENT_NAME m/MAX_SCORE`                                                                                                                                                                             |
| **Distribute Individual Assignments** | `assignIndiv INDEX n/ASSIGNMENT_NAME m/MAX_SCORE`                                                                                                                                                                             |
| **Edit**                              | `edit INDEX [n/NAME] [p/PHONE] [e/EMAIL] [t/TAG]… [c/COMMENT]…​` <br> e.g., `n/New Name t/`                                                                                                                                   |
| **Exit**                              | `exit​`                                                                                                                                                                                                                       |
| **Find**                              | `find KEYWORD [MORE_KEYWORDS]...` e.g., `find James Jake`                                                                                                                                                                     |
| **Find Group**                        | `findGroup KEYWORD [MORE_KEYWORDS]...` e.g., `findGroup group1 group2`                                                                                                                                                        |
| **Grade Assignments**                 | `grade INDEX n/ASSIGNMENT_NAME g/SCORE`                                                                                                                                                                                       |
| **Grade Group Assignments**           | `gradeGroup GROUP n/ASSIGNMENT_NAME g/SCORE`                                                                                                                                                                                  |
| **Group**                             | `group PREV_GROUP UPDATED_GROUP`                                                                                                                                                                                              |
| **Help**                              | `help​`                                                                                                                                                                                                                       |
| **Input Group Participation Points**  | `inputGroupPP GROUP t/TUTORIAL pp/POINTS`                                                                                                                                                                                     |
| **Input Participation Points**        | `inputPP INDEX t/TUTORIAL pp/POINTS`                                                                                                                                                                                          |
| **List**                              | `list​`                                                                                                                                                                                                                       |
| **List Participation Record**         | `listParticipation INDEX`                                                                                                                                                                                                     |
| **Mark Attendance**                   | `markAtd INDEX t/TUTORIAL s/STATUS`                                                                                                                                                                                           |
| **Mark Group Attendance**             | `markGroupAtd GROUP t/TUTORIAL s/STATUS`                                                                                                                                                                                      |
| **Unmark Attendance**                 | `unmarkAtd INDEX t/TUTORIAL`                                                                                                                                                                                                  |
| **Unmark Group Attendance**           | `unmarkGroupAtd GROUP t/TUTORIAL`                                                                                                                                                                                             |

--------------------------------------------------------------------------------------------------------------------
<a name="glossary"></a>
## Glossary

| Keyword                     | Definition                                                                           |
|-----------------------------|--------------------------------------------------------------------------------------|
| **Parameter**               | Details about the student that will be included in the command                       |
| **Command**                 | Instructions that `npc_track` will execute                                           |
| **JAR**                     | Compressed file of `npc_track` is in the form of a Java ARchive                      |
| **Attendance status**       | The student's attendance status which can be "present", "absent", or "valid reason". |
| **Attendance status: `:)`** | The emoji associated with "present".                                                 |
| **Attendance status: `x`**  | The emoji associated with "absent".                                                  |
| **Attendance status: `:/`** | The emoji associated with "valid reason".                                            |


## FAQ
<a name="FAQ"></a>
**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous StudentBook home folder.

**Q**: There are 12 tutorials on the attendance list, but my module has less than 12 tutorials per sem.<br>
**A**: In a typical semester, there are 13 weeks. Tutorials can start earlier or later, so to accomodate the largest possible number of tutorials, npc_track
has 12 weeks' worth of tutorials to grade.

**Q**: I have two students that share the exact same name. How can npc_track support this?<br>
**A**: npc_track cannot handle students with the exact same name. However, you can consider adding something else to their names to distinguish between them.

For example, if you have 2 students called "Arnab Goel", you can name one student "Arnab Goel 1" and the other "Arnab Goel 2".

**Q**: I can enter two students with the same telegram handle or same phone number (or something similar). Why is this allowed?<br>
**A**: npc_track allows this, much like a normal contacts application in your phone. We do not enforce too many checks as we want to enable
our users to use our app how they like, and support various unforeseen scenarios.
