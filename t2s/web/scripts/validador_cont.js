/**
 *  Author: RodrigoLopes
 *  Validar campos obrigatorios
 */

function validar() {
	let num_container = frmContainer.num_container.value
	let cliente = frmContainer.cliente.value
	let tipo = frmContainer.tipo.value
	let status = frmContainer.status.value
	let categoria = frmContainer.categoria.value

	if (num_container === "") {
		alert('Preencha o campo Container')
		frmContainer.num_container.focus()
		return false
	} else if (cliente === "") {
		alert('Preencha o campo Cliente')
		frmContainer.cliente.focus()
		return false
	} else if (tipo === "") {
		alert('Preencha o campo Tipo')
		frmContainer.tipo.focus()
		return false
	} else if (status === "") {
		alert('Preencha o campo Status')
		frmContainer.status.focus()
		return false
	} else if (categoria === "") {
		alert('Preencha o campo Categoria')
		frmContainer.categoria.focus()
		return false
	} else {
		document.forms["frmContainer"].submit()
	}
}