/**
 *  Author: RodrigoLopes
 *  Validar campos obrigatorios
 */

function validar() {
    let container = frmMovimentacao.container.value
    let movimentacao = frmMovimentacao.movimentacao.value
    let data_inicio = frmMovimentacao.data_inicio.value
    let data_final = frmMovimentacao.data_final.value

    if (container === "") {
        alert('Preencha o campo Container')
        frmMovimentacao.container.focus()
        return false
    } else if (movimentacao === "") {
        alert('Preencha o campo Movimentação')
        frmMovimentacao.movimentacao.focus()
        return false
    } else if (data_inicio === "") {
        alert('Preencha o campo Data e Hora do Início')
        frmMovimentacao.data_inicio.focus()
        return false
    } else if (data_final === "") {
        alert('Preencha o campo Data e Hora do Final')
        frmMovimentacao.data_final.focus()
        return false
    } else {
        document.forms["frmMovimentacao"].submit()
    }
}