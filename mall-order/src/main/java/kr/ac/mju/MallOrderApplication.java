package kr.ac.mju;

import kr.ac.mju.domain.repository.PurchaseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class MallOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallOrderApplication.class, args);
    }

    @Bean
    public CommandLineRunner execSampleCode(PurchaseRepository purchaseRepository) {
        return (args) -> {
            insertOrders(purchaseRepository);
            displayOrders(purchaseRepository);
        };
    }

    private void insertOrders(PurchaseRepository purchaseRepository) {
        // 테스트용 주문 생성
    }

    private void displayOrders(PurchaseRepository purchaseRepository) {
        // 테스트용 주문 목록 조회
    }
}