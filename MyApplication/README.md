README
------------------------------------------------------------------------------------------

Author: Paul Hundal

PullRequestApp

This application is made to show how Pull Requests can be shown from GitHub and how to view
the merge associated with that PR.

The app uses MVP pattern architecture and makes use of some key libraries, such as:

- Dagger2
- Butterknife
- Retrofit
- Okhttp
- GSON
- RxJava

The app also is modular in terms of each major component being separated out in its own module.

NOTE:

The GitHub api provides access to view diffs on a PR through its 'diff_url' attribute passed back
on the api call to get pull requests. This app makes use of that url to show the diffs. 

The app is not hardcoded to use only one repository, but it does preload to a common public repo
that I used for testing. Obviously, if the PR's get merged the user will need to point it to another repo.

Lastly, the app only shows PR's that are currently 'open'. 
