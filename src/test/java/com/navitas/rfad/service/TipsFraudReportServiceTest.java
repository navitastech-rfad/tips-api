package com.navitas.rfad.service;

import static org.mockito.BDDMockito.given;

import com.navitas.rfad.bean.TipsFraudReport;
import com.navitas.rfad.model.entity.Tips;
import com.navitas.rfad.model.repository.TipsRepository;

import java.util.Optional;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TipsFraudReportServiceTest {
  @InjectMocks private TipsFraudReportService service;

  @Mock private TipsRepository tipsRepo;

  @Test
  public void updateServiceTest() {
    final TipsFraudReport report = new TipsFraudReport();
    report.setId(UUID.randomUUID());
    final Tips tips = new Tips();
    final Optional<Tips> o = Optional.of(tips);

    given(tipsRepo.findById(ArgumentMatchers.any(UUID.class))).willReturn(o);
    service.updateService(report);
    Mockito.verify(tipsRepo, Mockito.times(1)).save(ArgumentMatchers.any());
  }

  @Test(expected = RuntimeException.class)
  public void updateServiceExceptionTest() {
    final TipsFraudReport report = new TipsFraudReport();
    report.setId(null);

    given(tipsRepo.findById(null)).willReturn(Optional.empty());
    service.updateService(report);
  }
}
