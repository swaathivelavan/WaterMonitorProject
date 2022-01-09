//Initializing firebase

  // Your web app's Firebase configuration
  var firebaseConfig = {
    apiKey: "AIzaSyC_-o8vNRxTSJR1ztISj2aePGU3EwnXJ_Y",
    authDomain: "complaintform-3a34b.firebaseapp.com",
    databaseURL: "https://complaintform-3a34b.firebaseio.com",
    projectId: "complaintform-3a34b",
    storageBucket: "complaintform-3a34b.appspot.com",
    messagingSenderId: "479822480689",
    appId: "1:479822480689:web:f230aaf139eafe29a4dc10"
  };
  // Initialize Firebase
  firebase.initializeApp(firebaseConfig);


  //Reference complaint collection

  var complaintsRef = firebase.database().ref('complaints');


//Listen for form submit

document.getElementById('complaintForm').addEventListener('submit',submitForm);

//To submit form

function submitForm(e)
{
e.preventDefault();

var name=getInputVal('full-name');
var area=getInputVal('area');
var telephone=getInputVal('telephone');
var complaint=getInputVal('complaint');

//Save the complaint

saveComplaint(name,area,telephone,complaint);

//Show alert

document.querySelector('.alert').style.display='block';

//Hide alert after 5 secs
setTimeout(function(){

document.querySelector('.alert').style.display='none';

},5000);

//Clear form

document.getElementById('complaintForm').reset();

}

//Function to get form values

function getInputVal(id)
{
return document.getElementById(id).value;
}

// Function to save the complaint to firebase

function saveComplaint(name,area,telephone,complaint)
{

complaintsRef.push({

name:name,
area:area,
telephone:telephone,
complaint:complaint

});

}

