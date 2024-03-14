# Suara Bersama

Overview:
Suara Bersama is a mobile application designed to serve as a platform for young individuals to exchange views on the 2024 presidential candidates and future elections (local elections, legislative elections, etc.). It aims to facilitate discussions among young voters, providing them with a space to solidify their political choices. The application operates as a social media platform with local data storage.

Highlighted Features:

1. Log-in/Register:

* Users can log in/register using their Google accounts.
* Account data is stored locally using SQLite DBHelper.
* Google login will save the username from the Google account to be used as the user's name.
* The homepage includes a RecyclerView displaying each candidate pair, linking to their respective profile pages.
* The homepage also contains buttons directing users to the "About Us" page.

2. Profile:

* Users' profiles store data such as name, occupation, gender, and email.
* The user's name is used as the sender's name in comments.
* The "About Us" page displays images of sponsors, linking to their respective websites.

3. Candidates' Profile Pages:

* Profiles provide brief information about each presidential candidate.
* Users have the opportunity to participate in discussions.
* Users can read and write comments using a RecyclerView.
* In the comments section, users input their comment intentions for the candidates along with the title and content of their comments. After submission, a dialog fragment prompts users for their name and location. Users can choose to remain anonymous, in which case the name defaults to "Anonymous" and the location defaults to "Jakarta."
* Comments for each candidate can be viewed on the candidate's profile page.
