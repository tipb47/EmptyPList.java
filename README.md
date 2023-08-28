This is the distribution repo for C343 that will contain the startercode for Assignments and Labs

## To Get Started
### Execute the following set-up steps in the terminal JUST ONCE.
1. Make sure that your github repo is named in the following format: username-submission.
2. Open the terminal in your computer and type the following commands to clone this repository
```console
foo@bar:~$ cd IdeaProjects
foo@bar:IdeaProjects$ git init 
Initialized empty Git repository in /Users/foo/IdeaProjects/.git/
foo@bar:IdeaProjects$ git clone https://github.iu.edu/CSCI-C343-Fall2023/distribution.git
```
3. Check for existing remotes.
```console
foo@bar:IdeaProjects$ cd distribution
foo@bar:distribution$ git remote -v
origin	https://github.iu.edu/CSCI-C343-Fall2023/distribution.git (fetch)
origin	https://github.iu.edu/CSCI-C343-Fall2023/distribution.git (push)
```
4. Rename the remote origin to upstream. This remote upstream is the Teacher's "distribution" repo.
```console
foo@bar:distribution$ git remote rename origin upstream
foo@bar:distribution$ git remote -v
upstream	https://github.iu.edu/CSCI-C343-Fall2023/distribution.git (fetch)
upstream	https://github.iu.edu/CSCI-C343-Fall2023/distribution.git (push)
```
5. Add your "username-submission" repo as remote origin.
```console
foo@bar:distribution$ git remote add origin https://github.iu.edu/CSCI-C343-Fall2023/username-submission.git
foo@bar:distribution$ git remote -v
origin	https://github.iu.edu/CSCI-C343-Fall2023/username-submission.git (fetch)
origin	https://github.iu.edu/CSCI-C343-Fall2023/username-submission.git (push)
upstream	https://github.iu.edu/CSCI-C343-Fall2023/distribution.git (fetch)
upstream	https://github.iu.edu/CSCI-C343-Fall2023/distribution.git (push)
```

## To Make Submissions:
The [Autograder page](https://autograder.luddy.indiana.edu) is only for your feedback. Your assignments would be manually graded, by referring to your username-submission repo. So make sure to update your repo for each Assignment/Lab in accordance to their deadlines. Any commits post-deadline would not be considered.
To do this:
1. First of all, make sure that the latest changes from the Teacher's repo "distribution" have been Pulled
```console
foo@bar:distribution$ git fetch upstream      # download latest from teacher repo
foo@bar:distribution$ git checkout main       # ensure you are on your main branch
foo@bar:distribution$ git merge upstream/main # add your changes on top of those from upstream
```
2. Commit your code to GitHub (replace <...> in the following commands with the proper arguments)
```console
foo@bar:distribution$ git add <LIST OF FILES/FOLDERS YOU WANT TO COMMIT SEPARATED BY SPACE>
foo@bar:distribution$ git commit -m "<MESSAGE IN DOUBLE QUOTES>"
foo@bar:distribution$ git push origin main
```
3. Create a text file on your local machine namely username_commit_hash.txt and copy YOUR FULL COMMIT URL in it. For example, the content of the file should look like this:
```console
https://github.iu.edu/CSCI-C343-Fall2023/username-submission/commit/26bc3f1a824151502adf56d061aaf5352d0216b2
```
4. Submit the text file (username_commit_hash.txt) with the latest commit hash to Canvas.
