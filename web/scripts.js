function drawGraph(r, jsonPoints) {

    if (r !== "R") {
        r = findCheckbox();
    }

    var image_1 = document.getElementById('canvas');
    var im = image_1.getContext('2d');
    im.clearRect(0, 0, 270, 270);

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
    im.fillText(r + "/2", 140, 99); //подписи по У
    im.fillText(r, 140, 60);
    im.fillText("-" + r + "/2", 140, 180);
    im.fillText("-" + r, 140, 220);

    im.fillText("-" + r + "/2", 81, 128); //подписи по Х
    im.fillText("-" + r, 47, 128);
    im.fillText(r + "/2", 165, 128);
    im.fillText(r, 210, 128);

    im.closePath();

    if (r !== 'R') {
        for (let i = 0; jsonPoints.length > i; i++) {
            let currP = jsonPoints[i];
            drawAfterChanging(currP.x, currP.y, r);

        }
    }
}


function drawAfterChanging(x, y, r) {
    let im = document.getElementById("canvas").getContext("2d");

    if ((x >= 0) && (y >= 0) && (x * x + y * y <= r * r / 4)) { //the first part
        im.fillStyle = "#B0FFC3";
    } else if ((x <= 0) && (y <= 0) && (-y <= r / 2) && (-x <= r)) { //the third part
        im.fillStyle = "#B0FFC3";
    } else if ((x >= 0) && (y <= 0) && (y >= 2 * x - r)) { //the fourth
        im.fillStyle = "#B0FFC3";
    } else {
        im.fillStyle = "red";
    }

    x = x * 80 / r + 135;
    y = 135 - y * 80 / r;

    im.beginPath();
    im.moveTo(x, y);
    im.fillRect(x, y, 2.7, 2.7);
    im.closePath();

}

function findCheckbox() {
    if (document.getElementById("main-form:r1_input").checked == true) {
        return '1';
    } else

    if (document.getElementById("main-form:r2_input").checked == true) {
        return '1.5';
    } else

    if (document.getElementById("main-form:r3_input").checked == true) {
        return '2';
    } else

    if (document.getElementById("main-form:r4_input").checked == true) {
        return '2.5';
    } else

    if (document.getElementById("main-form:r5_input").checked == true) {
        return '3';
    } else return 'R';


}

function drawPoint(event) {  //при нажатии обрабатывает точку с  запросом + добавляет в таблицу
    let r = document.getElementById("canvas_form:rCanvas").value;

    if ((r === undefined) || (r == null) || (r == "")) {
        alert("Выберите радиус для графика!");
    } else {
        let clRect = document.getElementById('canvas').getBoundingClientRect();
        let im = document.getElementById("canvas").getContext("2d");
        let canvas = document.getElementById("canvas");

        let offset = (clRect.width - canvas.width) / 2 + 1;

        let x = event.clientX - clRect.left - offset;
        let y = event.clientY - clRect.top - offset;

        x = (x - 135) * r / 80;
        y = (135 - y) * r / 80;


        document.getElementById("canvas_form:xCanvas").value = x.toFixed(3);
        document.getElementById("canvas_form:yCanvas").value = y.toFixed(3);


        if ((x >= 0) && (y >= 0) && (x * x + y * y <= r * r / 4)) { //the first part
            im.fillStyle = "#B0FFC3";
        } else if ((x <= 0) && (y <= 0) && (-y <= r / 2) && (-x <= r)) { //the third part
            im.fillStyle = "#B0FFC3";
        } else if ((x >= 0) && (y <= 0) && (y >= 2 * x - r)) { //the fourth
            im.fillStyle = "#B0FFC3";
        } else {
            im.fillStyle = "red";
        }

        x = x * 80 / r + 135;
        y = 135 - y * 80 / r;

        im.beginPath();
        im.moveTo(x, y);
        im.fillRect(x, y, 2.7, 2.7);
        im.closePath();
    }

}


