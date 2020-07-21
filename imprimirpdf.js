function demoFromHTML() {
    var pdf = new jsPDF('p', 'pt', 'letter');
    source = $('#content')[0];
    specialElementHandlers = {
        //lo que quieras saltear  del html dentro del div content metelo dentro de un div saltear
        '#saltear': function (element, renderer) {
            return true
        }
    };
    margins = {
        top: 80,
        bottom: 60,
        left: 40,
        width: 522
    };
    pdf.fromHTML(
        source, 
        margins.left, 
        margins.top, {
            'width': margins.width,
            'elementHandlers': specialElementHandlers
        },
        function (dispose) {
                pdf.save('Reporte.pdf');
            }, margins
        );
}