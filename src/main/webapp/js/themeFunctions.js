function changeTheme(color1, color2,color3) {
    const Styles =document.documentElement.style
    Styles.setProperty('--base-color', color1);
    Styles.setProperty('--second-color', color2);
    Styles.setProperty('--second-color-dark', color3);
}
