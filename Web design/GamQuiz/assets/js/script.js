function register(){
    
    var username = document.getElementsByName('username')[0].value; 
    var password = document.getElementsByName('password')[0].value; 
    var repassword = document.getElementsByName('repassword')[0].value; 

    if(username == '' || password == '' || repassword == ''){
        document.getElementsByTagName('h3')[0].innerText = 'پر کردن تمامی فیلد ها الزامی است';
        document.getElementsByTagName('div')[1].style.display = 'block';
        document.getElementsByTagName('div')[1].style.backgroundColor = 'red';
    }

    else if(!regexPattern.test(username)){
        document.getElementsByTagName('h3')[0].innerText = 'نام کاربری فقط می تواند شامل حروف انگلیسی باشد';
        document.getElementsByTagName('div')[1].style.display = 'block';
        document.getElementsByTagName('div')[1].style.backgroundColor = 'red';
    }
    
    else if(username.length < 3){
        document.getElementsByTagName('h3')[0].innerText = 'نام کاربری حداقل باید شامل ۳ نویسه باشد';
        document.getElementsByTagName('div')[1].style.display = 'block';
        document.getElementsByTagName('div')[1].style.backgroundColor = 'red';
    }

    else if(password.length < 8){
        document.getElementsByTagName('h3')[0].innerText = 'رمز عبور حداقل باید شامل ۸ نویسه باشد';
        document.getElementsByTagName('div')[1].style.display = 'block';
        document.getElementsByTagName('div')[1].style.backgroundColor = 'red';
    }

    else if(password !== repassword){
        document.getElementsByTagName('h3')[0].innerText = 'رمز عبور وارد شده و تکرار آن یکسان نیست';
        document.getElementsByTagName('div')[1].style.display = 'block';
        document.getElementsByTagName('div')[1].style.backgroundColor = 'red';
    }

    else {
        document.getElementsByTagName('h3')[0].innerText = 'ثبت نام با موفقیت در سایت انجام شد';
        document.getElementsByTagName('div')[1].style.display = 'block';
        document.getElementsByTagName('div')[1].style.backgroundColor = 'green';
    }
};

function login() {
    
    var username = document.getElementsByName('username')[0].value; 
    var password = document.getElementsByName('password')[0].value; 

    if(username == '' || password == ''){
        document.getElementsByTagName('h3')[0].innerText = 'پر کردن تمامی فیلد ها الزامی است';
        document.getElementsByTagName('div')[1].style.display = 'block';
        document.getElementsByTagName('div')[1].style.backgroundColor = 'red';
    }

    else if(!regexPattern.test(username)){
        document.getElementsByTagName('h3')[0].innerText = 'نام کاربری فقط می تواند شامل حروف انگلیسی باشد';
        document.getElementsByTagName('div')[1].style.display = 'block';
        document.getElementsByTagName('div')[1].style.backgroundColor = 'red';
    }

    else if(username.length < 3){
        document.getElementsByTagName('h3')[0].innerText = 'نام کاربری حداقل باید شامل ۳ نویسه باشد';
        document.getElementsByTagName('div')[1].style.display = 'block';
        document.getElementsByTagName('div')[1].style.backgroundColor = 'red';
    }

    else if(password.length < 8){
        document.getElementsByTagName('h3')[0].innerText = 'رمز عبور حداقل باید شامل ۸ نویسه باشد';
        document.getElementsByTagName('div')[1].style.display = 'block';
        document.getElementsByTagName('div')[1].style.backgroundColor = 'red';
    }
    
    else {
        document.getElementsByTagName('h3')[0].innerText = 'ورود با موفقیت انجام شد';
        document.getElementsByTagName('div')[1].style.display = 'block';
        document.getElementsByTagName('div')[1].style.backgroundColor = 'green';
    }
}