package com.example.demokeyvalut;

import com.azure.identity.ManagedIdentityCredentialBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import com.azure.security.keyvault.secrets.models.KeyVaultSecret;

@SpringBootApplication
public class DemoKeyvalutApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoKeyvalutApplication.class, args);

        System.out.println("----------------------------------------->");
        System.out.println(System.getenv());

        SecretClient secretClient = new SecretClientBuilder()
                .vaultUrl("https://testkeyprasad.vault.azure.net/")
                .credential(new DefaultAzureCredentialBuilder().build())
                .buildClient();


        KeyVaultSecret secret = secretClient.getSecret("barunKey");
        System.out.printf("Retrieved secret with name \"%s\" and value \"%s\"%n", secret.getName(), secret.getValue());

        secret = secretClient.getSecret("NaiduKey");
        System.out.printf("Retrieved secret with name \"%s\" and value \"%s\"%n", secret.getName(), secret.getValue());

        secret = secretClient.getSecret("vilasKey");
        System.out.printf("Retrieved secret with name \"%s\" and value \"%s\"%n", secret.getName(), secret.getValue());

        System.exit(0);
    }
}
