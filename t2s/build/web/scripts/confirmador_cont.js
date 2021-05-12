/**
 *  Author: RodrigoLopes
 *  Confirmacao de exclusao de um container
 *  @param id_cont
 */

function confirmar(id_cont) {
	let resposta = confirm("Confirma a exclusão deste container? " + id_cont)
	if (resposta === true) {
		window.location.href = "delete_cont?id_cont=" + id_cont
	}
}