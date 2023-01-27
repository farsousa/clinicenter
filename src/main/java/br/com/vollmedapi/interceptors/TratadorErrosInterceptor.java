package br.com.vollmedapi.interceptors;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class TratadorErrosInterceptor {
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> tratarErro404() {
		return ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> tratarErro400(MethodArgumentNotValidException exception) {
		List<FieldError> erros = exception.getFieldErrors();
		return ResponseEntity.badRequest().body(erros.stream().map(TradadorErroDtoDetalhamento::new).toList());
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<?> tratarErro409(DataIntegrityViolationException exception) {
		String erro = exception.getMessage();
		int posicaoInicial = erro.lastIndexOf(".") + 1;
		int posicaoFinal = erro.lastIndexOf("]");
		String campo = erro.substring(posicaoInicial, posicaoFinal);
		String erroPersonalizado = "Houve uma violação de integridade para o campo de " + campo;
		return ResponseEntity.status(409).body(new TradadorErroDtoDetalhamento(campo, erroPersonalizado));
	}
	
	private record TradadorErroDtoDetalhamento(
			String campo, 
			String mensagem
	) {
		public TradadorErroDtoDetalhamento(FieldError erro) {
			this(erro.getField(), erro.getDefaultMessage());
		}
	}

}


