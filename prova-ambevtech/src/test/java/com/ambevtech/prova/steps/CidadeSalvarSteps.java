package com.ambevtech.prova.steps;

import com.ambevtech.prova.SpringIntegrationTest;
import com.ambevtech.prova.dto.CidadeTesteDto;
import com.ambevtech.prova.utils.Validators;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import io.restassured.response.Response;

public class CidadeSalvarSteps extends SpringIntegrationTest {

    private Response response;
    private CidadeTesteDto dto;
    private String cenario = "Salvar cidade";

    @Dado("^que possuo uma cidade para salvar \"([^\"]*)\" \"([^\"]*)\"$")
    public void quePossuoUmaCidadeParaSalvar(String nomeCidade, String uf) throws Throwable {
        dto = new CidadeTesteDto();
        dto.setNome(nomeCidade);
        dto.setUf(uf);
    }

    @Quando("^confirmar o registro$")
    public void confirmarORegistro() throws Throwable {
        response = postMessage(dto, "/cidade");
    }

    @Então("^deve me retornar um status de \"([^\"]*)\"$")
    public void deveMeRetornarUmStatusDe(String status) throws Throwable {
        Validators.validaStatus(cenario, response, status);
    }
}
