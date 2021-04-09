function changeTheme(i) {
    const Styles =document.documentElement.style
    let base = Styles.getPropertyPriority('--base-color')
    let anti = Styles.getPropertyPriority('--anti-color')

    if(i!=null) {
        switch (i) {
            case 0:
            case "0":
                base = '#fff';
                anti = '#171718';
                break;
            case 1:
            case "1":
                base = '#fff'
                anti = '#5d5d5d';

                break;
            case 2:
            case "2":
                base = '#171718';
                anti = '#fff'
                break;

        }
        Styles.setProperty('--base-color', base);
        Styles.setProperty('--anti-color', anti);
    }

}
function changePrimColor(c)
{
    const Styles =document.documentElement.style;
    let primary = Styles.getPropertyPriority('--primary-color')
    if(c!=null) {
        switch (c) {
            case 0:
            case "0":
                primary = '#ef7030'
                break;
            case 1:
            case "1":
                primary = '#8462c8'

                break;
            case 2:
            case "2":
                primary = '#2fa1a6'
                break;

        }
        Styles.setProperty('--primary-color', primary);
    }
}
window.onload = function() {
    const c = getCookie("theme_c");
    if(c!=null){
        console.log(c);
        changePrimColor(c.charAt(0));
        changeTheme(c.charAt(1));
    }

};
function getCookie(name) {
    const value = `; ${document.cookie}`;
    const parts = value.split(`; ${name}=`);
    if (parts.length === 2) return parts.pop().split(';').shift();
}

    function onSignIn(googleUser) {
    // Useful data for your client-side scripts:
    var profile = googleUser.getBasicProfile();
    console.log("ID: " + profile.getId()); // Don't send this directly to your server!
    console.log('Full Name: ' + profile.getName());
    console.log('Given Name: ' + profile.getGivenName());
    console.log('Family Name: ' + profile.getFamilyName());
    console.log("Image URL: " + profile.getImageUrl());
    console.log("Email: " + profile.getEmail());

    //so, we can get the data from here, now... how do we send with a post request?

    // The ID token you need to pass to your backend:
    var id_token = googleUser.getAuthResponse().id_token;
    console.log("ID Token: " + id_token);
}
