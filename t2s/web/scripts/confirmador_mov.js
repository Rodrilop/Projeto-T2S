/**
 *  Author: RodrigoLopes
 *  Confirmacao de exclusao de uma movimentacao
 *  @param id_mov
 */

function confirmar(id_mov) {
	let resposta = confirm("Confirma a exclusão desta movimentação? " + id_mov)
	if (resposta === true) {
		window.location.href = "delete_mov?id_mov=" + id_mov
	}
}