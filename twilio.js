const accountSid = 'AC4515dc8a9ef011f9b0887e72ff8730fc';
const authToken = '8a730a9bb4db34fcc0948843140bc57c';
const client = require('twilio')(accountSid, authToken);
const axios = require('axios');
const QUANTUM =  2;
let threshold = QUANTUM;
let todayDate = '';

function sendSMS(message){
  client.messages
    .create({
      body: message,
      from: '+12017343085',
      to: '+919710088934'
    })
    .then(message => console.log(message.sid));
}

function getFeeds(raw){
    return raw.data.feeds.filter(e=>e.field2);
}

function initialSetup(){
    axios.get(`https://api.thingspeak.com/channels/994647/feeds.json?key=CG74J0CQ8OO95BHV`)
        .then(res=>{
            const feeds = getFeeds(res);
            
            const last = feeds.pop();
            
            todayDate = last.created_at.split('T')[0];
            
            console.log(todayDate);
            
            runPeriodic();
        }).catch(console.error);
}

function runPeriodic(){
    axios.get(`https://api.thingspeak.com/channels/994647/feeds.json?key=CG74J0CQ8OO95BHV`)
        .then(res=>{
            const feeds = getFeeds(res);
            
            const todayFeeds = feeds.filter(e=>e.created_at.startsWith(todayDate));
            const todayValues = todayFeeds.map(e=>e.field2);
            
            const todayTotal = todayValues.reduce((acc,e)=>acc+ (+e), 0);

            console.log(threshold);
            
            
            if(todayTotal > threshold){
                console.log("inside");
                sendSMS('Alert!');
                sendSMS(todayTotal);
                console.log(todayTotal);
                threshold+=QUANTUM;
            }
        }).catch(console.error);
}

const DURATION = 5 * 1000;

initialSetup();
setInterval(runPeriodic, DURATION);
