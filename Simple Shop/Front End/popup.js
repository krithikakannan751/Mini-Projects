function printShirt() {
    alert("Clicking the shirt triggers JS!");
}

function printPants() {
    alert("Clicking the pants triggers JS!");
}

window.onload = function() {
    document.getElementById("shirt_img").addEventListener("click", function() {
        printShirt();
    });
    document.getElementById("pants_img").addEventListener("click", function() {
	printPants();
    });
    document.getElement
    chrome.storage.sync.get({
        waistSize: 29,
        inseamSize: 34,
        chestSize: 35
    }, function(items) {
        document.getElementById('waist_display').innerHTML = (items.waistSize) + "\"";
        document.getElementById('inseam_display').innerHTML = (items.inseamSize) + "\"";
        document.getElementById('chest_display').innerHTML = (items.chestSize) + "\"";
    });
}
chrome.identity.getProfileUserInfo(function(userinfo) {
    var email = userinfo.email;
    if (email == null || email == "") {
        chrome.storage.sync.set({
            userEmail: "empty"
        });
    } else {
        chrome.storage.sync.set({
            userEmail: email
        });
    }
});

chrome.tabs.query({
    'active': true,
    'lastFocusedWindow': true
}, function(tabs) {
    var url = tabs[0].url;
    if (url != null) {
        let re = new RegExp("http[s]?:\/\/(www\.)?([^\/]+)\/");
        var match = re.exec(url);
        if (match != null) {
            var cut = match[2].lastIndexOf(".");
            var webName = match[2].substring(0, cut);
            chrome.storage.sync.set({
                websiteName: webName
            });
        };
    }

});