const extract = {
    init: () => {
        $('#btn-extract').on('click', () => {
            extract.extract()
        })
    },
    extract: () => {
        const start = $('#start').val()
        const end = $('#end').val()

        const body = []
        for (let i = start; i <= end; ++i) {
            body.push(i)
        }

        $.ajax({
            type: 'POST',
            url: '/api/lottery/extract',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(body)
        }).done((response) => {
            alert("SUCCESS : " + JSON.stringify(response))
            window.location = '/admin'
        }).fail((error) => {
            alert(JSON.stringify(error))
        })
    }
}
extract.init()