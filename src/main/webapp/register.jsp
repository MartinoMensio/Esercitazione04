<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:template>
	<jsp:attribute name="header">
      <%@include file="components/navbar.jsp"%>
    </jsp:attribute>
	
	<jsp:attribute name="footer">
		<div id="pagefooter" class="row">
			<%@include file="components/footer.jsp"%>
		</div>
    </jsp:attribute>
	    
	<jsp:body>
		<form class="form-horizontal" action="#" method="POST" enctype="application/x-www-form-urlencoded">
			<div class="form-group" style="padding-top: 100px;">
				<label class="control-label col-sm-2" for="firstName">Nome:</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="firstName" required="required">
			    </div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="lastName">Cognome:</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="lastName" required="required">
			    </div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="birthdate">Data di nascita:</label>
				<div class="col-sm-4">
					<input type="date" class="form-control" id="birthdate" required="required">
			    </div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="address">Indirizzo:</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="address" required="required">
			    </div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="city">Città:</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="city" required="required">
			    </div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="cap">CAP:</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="cap"  required="required">
			    </div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="telephone">Telefono:</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="telephone"  required="required">
			    </div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="cellphone">Cellulare:</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="cellphone">
			    </div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="organization">Organizzazione:</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="organization">
			    </div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="email">E-mail:</label>
				<div class="col-sm-4">
					<input type="email" class="form-control" id="email" required="required">
			    </div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="password">Password:</label>
				<div class="col-sm-4">
					<input type="password" class="form-control" id="password" required="required">
			    </div>
			</div>
			<button type="button" class="btn btn-primary" onclick="submit()">Registrati</button>
		</form>
		
		<!-- We need this: 
		a. Genere 
		b. Età 
		c. Livello di istruzione (scegliere da un insieme predefinito) 
		d. Occupazione (scegliere da un insieme predefinito) 
		e. Possesso di un’auto privata; nel caso di risposta affermativa aggiungere i campi: 
			i. Anno di immatricolazione 
			ii. Tipologia di carburante (scegliere da un insieme predefinito) 
		f. Utilizzo di un servizio di car sharing; 
			nel caso di risposta affermativa scegliere il fornitore del servizio 
			(scegliere da un insieme predefinito) 
		g. Utilizzo della bicicletta; 
			nel caso di risposta affermativa indicare se si utilizza una bici privata 
			e/o il servizio di bike sharing 
		h. Utilizzo dei mezzi pubblici; 
			nel caso di risposta affermativa indicare il titolo di viaggio utilizzato più frequentemente
			(scegliere da un insieme predefinito) 
		-->

    </jsp:body>
</t:template>