function drawGraph() {
    var image_1 = document.getElementById('image_1');
    var im = image_1.getContext('2d');

    im.fillStyle = 'DodgerBlue';
    im.fillRect(55, 135, 80, 40);
    im.beginPath();
    im.moveTo(135, 135);
    im.lineTo(175, 135);
    im.lineTo(135, 216);
    im.lineTo(135, 135);
    im.fill();

    im.beginPath();
    im.moveTo(135, 135);
    im.arc(135, 135, 40, -Math.PI / 2, 0, false);
    im.closePath();
    im.fill();

    im.lineWidth = 2;
    im.strokeStyle = 'BLACK';

    im.beginPath();
    im.moveTo(128, 17); //ось Y
    im.lineTo(135, 10);
    im.lineTo(142, 17);
    im.moveTo(135, 10);
    im.lineTo(135, 55);
    im.lineTo(139, 55);
    im.lineTo(131, 55);
    im.moveTo(135, 55);
    im.lineTo(135, 95);
    im.lineTo(139, 95);
    im.lineTo(131, 95);
    im.moveTo(135, 95);
    im.lineTo(135, 175);
    im.lineTo(139, 175);
    im.lineTo(131, 175);
    im.moveTo(135, 175);
    im.lineTo(135, 215);
    im.lineTo(139, 215);
    im.lineTo(131, 215);
    im.moveTo(135, 215);
    im.lineTo(135, 260);
    im.stroke();

    im.lineWidth = 2; // ось Х
    im.strokeStyle = 'BLACK';
    im.beginPath();
    im.moveTo(10, 135);
    im.lineTo(55, 135);
    im.lineTo(55, 139);
    im.lineTo(55, 131);
    im.moveTo(55, 135);
    im.lineTo(95, 135);
    im.lineTo(95, 139);
    im.lineTo(95, 131);
    im.moveTo(95, 135);
    im.lineTo(175, 135);
    im.lineTo(175, 139);
    im.lineTo(175, 131);
    im.moveTo(175, 135);
    im.lineTo(215, 135);
    im.lineTo(215, 139);
    im.lineTo(215, 131);
    im.moveTo(215, 135);
    im.lineTo(260, 135);
    im.lineTo(253, 128);
    im.moveTo(261, 135);
    im.lineTo(253, 142);
    im.stroke();


    im.fillStyle = 'BLACK';
    im.font = "13px Century Gothic";
    im.fillText("y", 145, 11);
    im.fillText("x", 255, 125);

    im.font = "15px Century Gothic";
    im.fillText("R/2", 140, 99); //подписи по У
    im.fillText("R", 140, 60);
    im.fillText("-R/2", 140, 180);
    im.fillText("-R", 140, 220);

    im.fillText("-R/2", 81, 128); //подписи по Х
    im.fillText("-R", 47, 128);
    im.fillText("R/2", 165, 128);
    im.fillText("R", 210, 128);
}


function validate() {
    document.getElementById("error").innerHTML = "  ";
    var rboxs = document.getElementsByClassName("checkbox2");
    var fr = 0;

    var y = document.getElementById("y").value;
    var yReg = /^(?!-0$)-?(3$|([0-2](\.\d+)?))$/;

    if (yReg.test(y) == false) {
        document.getElementById("error").innerHTML = "Введенное значение Y некорректно!";
        return false;
    }

    for (var j = 0; rboxs.length > j; j++) if (rboxs[j].checked) {
        fr = fr + 1;
    }
    if (fr == 0) {
        document.getElementById("error").innerHTML = "Выберите радиус!";
        return false;
    }
    return true;
}

function activeBut() {
    document.getElementById("main-form:butt").disabled = false;
}

function checkPointInArea(x, y, r) {
    // x = document.getElementById("x").value;
    alert(x);
    // y = document.getElementById("y").value;
    alert(y);
    // r = document.getElementById("r").value;
    alert(r);

    for (var rCurr in r) {
        if ((x >= 0) && (y >= 0) && (x * x + y * y <= rCurr * rCurr / 4)) { //the first part
            drawPoint(x, y, r, 1);
        } else if ((x <= 0) && (y <= 0) && (-y <= rCurr / 2) && (-x <= rCurr)) { //the third part
            drawPoint(x, y, r, 1);
        } else if ((x >= 0) && (y <= 0) && (y >= 2 * x - rCurr)) { //the fourth
            drawPoint(x, y, r, 1);
        } else {
            drawPoint(x, y, r, 0);
        }
    }
}

function drawPoint(x, y, r, isPointInArea) {
    var image_1 = document.getElementById('image_1');
    var im = image_1.getContext('2d');
    if (isPointInArea == 1) {
        im.fillStyle = "#B0FFC3";
    } else {
        im.fillStyle = "red";
    }

    im.beginPath();
    im.moveTo(x * 80 / r + 135, 135 - y * 80 / r);
    im.fillRect(x * 80 / r + 135, 135 - y * 80 / r, 2.7, 2.7);
    im.closePath();
}

// TO FIX
function onChangeRadius(id) {
    alert("Передалось в функцию:" + id);
    var r1 = document.getElementById("main-form:r1_input");
    var r2 = document.getElementById("main-form:r2_input");
    var r3 = document.getElementById("main-form:r3_input");
    var r4 = document.getElementById("main-form:r4_input");
    var r5 = document.getElementById("main-form:r5_input");

    if (id ==r1.id){
        alert('1');
        r2.checked = false;
        r3.checked = false;
        r4.checked = false;
        r5.checked = false;
    }

    if (id ==r2.id){
        r1.checked = false;
        r3.checked = false;
        r4.checked = false;
        r5.checked = false;
    }

    if (id ==r3.id){
        r2.checked = false;
        r1.checked = false;
        r4.checked = false;
        r5.checked = false;
    }

    if (id ==r4.id){
        r2.checked = false;
        r3.checked = false;
        r1.checked = false;
        r5.checked = false;
    }

    if (id ==r5.id){
        r2.checked = false;
        r3.checked = false;
        r4.checked = false;
        r1.checked = false;
    }
}

