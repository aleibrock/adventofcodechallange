package net.leibi.adventofcode2022.day3;

public class Input {

  public static final String small = """
      vJrwpWtwJgWrhcsFMMfFFhFp
      jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
      PmmdzqPrVvPwwTWBwg
      wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
      ttgJtRGJQctTZtZT
      CrZsJsPPZsGzwwsLwLmpwMDw
      """;

  public static final String large = """
      JppMDcJPcQbqGqFb
      ZStgnHtsSjGBhqFbBmsm
      djzzwgHHggdnfwjtMPDPMGpPlNfpLDll
      dRCtwtlCSttPtlNPNtgvPrDqmBsjGSpjBBsJsqqmrp
      ZhWnZhzMMfnWWTDzBrmsmjsBccJB
      TFQMrZrMfZrLZZnLQdlvNdCgdHPlCllHNF
      PVddPnZWDDPqmHZzqVPzqdHdMRMJjQtvmvjvtTQQtlRtbbQl
      fsNswFpChpNwfgtMvCbjTRJBbtRj
      SFgfSMShLcsLgNMFhpwShFFZPHqZGZPqHdzPZHZcdzDDqd
      dHffzCqSfJCCzCPvdcpzRrBDDBSBBBMtthDDrFMT
      bVsZbsrgbWshBTFtDTtZTD
      slWGNbNWgWwnmNnwgnlGjdJJdPHcvcrcHjqPzdqPvp
      vBFBzGvGBvjFpGWcvCCvBvGPPhZbgLhMnhrPgFgPFgLLPF
      dVlslfdJNVJJmQQwdNRNwLZZZrrqhbPbZndpdgMhLP
      HJRHJpNJlVmftHfNQNRsHmmGCtGWjGDDTvCzcjWDStvcvT
      cVQzCCCpVVjgHsNwwFRqSRSRRtNH
      PWfhfPhbWWdWllPDdTvdbnvhLJLLMJFTSNwJtMRwJLqJJNMq
      DnfblllPbDrbWmbdPFdvlhdgQzzZZzQgcpcsZGcGQQgcpr
      hdFnnrdLnJRrZMzVlMbrwZvz
      TgfjGCcfsqfqqBfRMPDVvVVvTZRPbP
      qQqffcGStBSCQcsqCCBRjGqWhHFptFdnhNLmhnLWmphLLt
      WHPqWhLWHBMqddCdtDRwStDSwgnw
      rfCfZTmvpvvpFVfFrbvTbvcgtwgtStntggwbSJttgJtwgw
      fpQFsmfFmfZcrFCMhWNQWLCzhhCM
      zdqqJHDWwqNNZjQSmtdjpmfnjj
      GFBcPfBLPThcTcLRbpTQQjpTQrjSnQjlvn
      MFVLcsPVbPcRGfVPFRgDzJsHZNDCZNCNZsHg
      WQdMhlmQMwfZlQdgdHfddvtzmbJbcsctbBJqqcvqzB
      rSTrDDCSSGRCnnSGwwzJsbBvJsCCttccsvsz
      VnFwDrNwPwVSDrLgjfZZdMQFMWgljQ
      rJNjBLNQjvLQjFFLQJCFTvGWlRRgfGWDWlCDzlGnRRWG
      tMMhShhwhbgplflwDlnnnzDH
      ZcSZVMSqshhQBQqQvqQgjJ
      btTtWGbvtcvHHccdNRhHdl
      TDzqLPSqBzqVSldPddHhhNNlRQ
      jBLDqDgZZBzJJmsbWjppmmpTWw
      LLDTRRfTwZRGZfDCRTwRsVHsVFBVZVlmVFBFlFJl
      QjWpQrzQcbhfMqrVVHVPFslFVpVmHH
      hqhzqMfNvjvMMzhdRDdCwGDSSdnvRn
      jmMdNCLjLmJPtHtSHhSVVJ
      pDBqgBgCvbfGBBbCGHZhtQZtPHVSVHPV
      pBnWgBpzWzBbWDWvzwpgCvqcmLNTrdLmmrnRLTrmrTdmLd
      dRWWtRGBDPQctQDZ
      CMfnCfFMmTTFVCmfmTLvsnMPZjccHRcPrRPsZQQZPQDRrQ
      fLCffmRTCvRnmTllzVvpdpphNJggpGbJJJpdlh
      cfsfbbWqqZqDScbhGDPDjTPmpVtmmPjPntFD
      dCBBCRQCHNHLMQvrJJJBJLrGPMnjVtPjVMmnjPFmPmMpFn
      HvRGLddgHHvqhwzbWhcgcf
      DHmhhDDhbqrRhvbrHqhPbPvBwwWwTmMGTVwwBMGWVNNwVw
      gSzJjnnjsscfcsZcSfWwQGdMMcWTBcTTMTMw
      nsFCCFZsnSlCFBFflfflsztRPCqvvHPttRbHbhvPrrRr
      SGNRLzpNpgNSNNlWFNwzqJfHfJHBtBdJhBJrHd
      bQnjPTnjVdZtPPrfLP
      TTnTccLnjGFcDNggFl
      lBJmNzJlzmmQBlzgVVjLWRDfLjRsRLWWRS
      vTMvTvtrfdhrrrPTdZwTTwtDqSSnWFWDFMMsRssjjsRqWD
      ZpbvHbZddtbrdrdhcBmmpGQfBQgJNcmz
      qsmhTmTVcDdcffhPhPvvzFhF
      BNNlJbjWBWjtRtNljbmBBCpFzPlFPgpPfwFnlffnlPgg
      JtBmmrrrRbDSrVqDqVSD
      VmSgpSLgJjVDMrFrmMlfFmsG
      bZWhZbzWcCwTWPRCwwwSPQzwMHnflHnGsMGnTrsflGMnlfTF
      CqWhWqWCCWRRZQcLqDLpVDDLNStpgD
      JwzTVzzcLzVJVVlJpVTwzGcrWhFjqsBjCjQFjWcCCjCjBF
      MDSNQMtbSSnSbgbRDvnRNgvhmrqrjBCBtmCrCCWFqthhWm
      bgMfNSSNZTwZQddGJZ
      jjPgbFjjStjjPcSbrbtpvNrGnGDvBnMGvNDNGG
      LwdZwsTdWTTmwDNCNppGBsnpBR
      mWmHwZWhTTJWHBdQQWBjcFczSgjlSftjbtQPzg
      fCBlrffzlCzcmfLDlfgRRnHScsHvRSQHMQvs
      LthpZqtpVThZhGJtqTFvHsVnvsvMsggjHQjgQH
      ZWFWGTLTWBNCWfDfmD
      BpFqJrpcZZBDhDsNqMHhRG
      zwlzPdmzPLhwvhMgsHnN
      mPlWjlQfQjjllWtjQCWzCrBFJFTBcSNcJbbZfcZJSb
      FpzNFTThBDChnnzNBCBNDzWGndgWqbJWVGqmPbJqQgQm
      HQRctcvwgddVcJGd
      LwRMZLjQfSRjFNzFSrhNsThS
      WgRWVLWhFqgqgcgWHqLRWHVRbbbNwBmtBcNcwdwwBNwBzwBN
      pSfssjDSrSvJpNJCztbJBtMNbt
      TzsvGGnjGPsPjSTpDrPfPDSHhWqLgZZVHVhZZZZVQQFLnZ
      sHjtPjQTtDbsfrrqWR
      ZmccchvlvSvvZNMVNhvBLWRJJblWJWJlJfwHbwlL
      hMMBzSMppVSzSNNmNgHjPgGPFTCpTTgTgG
      rPQpCPPCQQZdcFhcZgzVJgwt
      vDBSHmvHSSMlDWWmljnHBvFwzzcrwhVSJwVFtzcJJghw
      bmmrsrsbsvNdCTdbPTdb
      NgzBnsBNnfjgNvvfvWbtShSSFSMLJMFjjbPh
      CCcRHdlQrQPLTJPLGP
      HrDlRcqcDJCCDJHlcplrDJDfgfzBWWNZfvsnNqWwngZWwW
      TggFVbjVTVzRwFFjjqBBqpzNztqcQqNNqN
      SnZPrWndmShSZSPsnSLsJhpMQpcJtNqBClltqctC
      mfWsGdnZZWmZmrLSfsrnmPggwtggRgGTVHvRwgFDjTGT
      wQMZFQwppbPHPbLQJsgQNJJmBnds
      qrSGvRRCvTzTDNnhNgmCgdBm
      qzRrcRlGjvvzlzrvjcGqSSzMHWwVdPMWFpFMHMHWlPWMVV
      BccsFzrBcsfpccccgFmQqlGNqCTLTlQnqgLlRG
      MZbVSMddddSPPtdHPVJPJdTllqLNLGGTNCCRhTnHTQHh
      DMwtbVZDZbSbpprcpccppwrq
      bSZTdNqFjjzjqQMQ
      WtRztLsWJpPLzrsMDlDQjMhVMC
      pcgHRpHmWPJgLRzBJHBPPRBfvvfGNGvvFwfvSvfTmNNZfN
      RjvBljWTTWTlqmBvHjGptRgccZcbPtcttbpzbn
      VhDSDdJLJpSNNVVznPzzzSzcZFngZt
      LsMdQNVMHsBHjqps
      rSPSLTnSCClfSFCR
      MwtZgwNBzzTjzZMbbmjNtwmBcRvFqQllqtQRlFRVqRqVVcvq
      TsMhZsjNjBbTbBbwZLpDnHdDGdHWnpGHnh
      LfdssTFBjFHSwlhzCcZZgMMfMhZZ
      DmtDvrpmNStVvqpPczrZMMhZhhChCC
      vJtJpQWvNVDtJFbHlJSlBbSF
      PgvHLbcgRcGGHzRvgGgchBzsCZnmNZmZddrCrvdddZCZrF
      JQBMjlStJrQsZFrNCZ
      JSJTlqMtjptlplSSqJVDBqphwhhwHRPRggGbGzHbgzVRPH
      pBsztsZdBsnWhntVnhtVTqTWNQlGGTGGFFlQFlTl
      fDvLSMcbDbfMrGqFqSGwSQPzqz
      zjcvLMMvffLjgggzfjjJCCLcdBtRphddBmmZBpCZZpZpmmhs
      gmmSDplcPHDfHDlbVNrtCtCCNqHvTn
      QGwJjzdPMzJhFLwnbvMqrTVCCMnvMv
      LQQZdGjGdJhFBFQGjLGBJzzsBSWcPflllcfmDmfBsmBWPs
      sMppbLDRMQbrTDTJjwcqnfnjwwnw
      CgmFgSPHPzHgdmJWZZFzCzZZcVnGGnttWtVVVnccfjVqwVff
      PhCChPSNgPgPJhPHhFZgsDNRspsvMNQLRvNDvpbD
      pHnVnlRGVpfgpfgCpCTz
      LCNQPqZCqNSSZCStzPgTmztwPfzwzT
      dbSqhjhqQhNLQLFjLjGvFcRnCcsvRVvvsFnG
      QTdnDTDQbCnMdbqdwSmJBljFJZhttJZMSh
      HfNfLNzGLsgWBpGJthlZFBSB
      ssRPHPfNsWHzZZvrvHfgLzNwnbbVVRwwRbVVcqDTddCVdD
      ZhZBrJssjrNsbRtWpjwjlmlm
      qTfHzGTfTGqqLGMdCCRcmmRRZcbPMccWmcRw
      dVCZdDHdGHQhBVNJSsBhBF
      NsplbGDbblHcbCpDlDGDPlPpJjdrVjgrvHnghvVdJrJdvvdn
      tQFMZNWSmWFQRzQSwtzFmwFFJdVBghVrnBjVjBgrvVjMvrhJ
      FFRmFZZRzQRmFLQSZZWQWFCPCNGcTCpGpfGfLTpblpff
      dnhQHqQCnqWwNQCwCRRdJjjJVVPmVVJsJP
      LccFRDgfMgLFBJVlmVVmgjrPzZ
      pvfGpRpSpTnTQbvbTv
      nwNlWwhWwNmJvQQdzdzZGMqDzn
      rcVscPfrLcfvjTFcQDqGdZqMzMSHZHjS
      LsfbbFcvVgRRblJRNR
      Rmrrlmltcffhllfl
      DDZMMMFZVsFsWZDSHhPPfgQbPPnQgcHctf
      zGMGSBVDWCrvwjtBvm
      DCZHwdDwNNGNZDZCjjtpTHLvtlgLbRLttlTL
      BzPzBJffJJQgLlRgGztQ
      PJffcJhJfNNSwFhGZC
      blplfHbwZSfbcbwSbfVSHDHcNvdrvrWsCrvWVCRWnvNndtWW
      hQzBTQLLMBWBsnsnNC
      zMsgTjqTqPpZHbfp
      ZLNNLtfZhRJQtpQhNRttZRqcGFcqGBzjrcqclGScFljjcj
      VnvVVPMWHwgJCMvwdcGFdFrGcwzGBG
      WHgPJJvWVTgnvgvTHmWCHmsNZRtNRDZpfZQffZZssR
      rZgMFMVVjGbVSqZbhftLRDmCGRCNDCtm
      cdddQzdWsWnQvzscnfRHmfnDNtLNChRmfH
      zplDQdDzwszlDsWdPcldzMFFrFrBFgpqVBZgSgZFrF
      gbzfbTvbJgbvzvTvJvJmzvjcBBQSfWDLCSBQQfLZWSCdBHHD
      GhnMhsGrMNPPwnwsRPNsFCZDWHZdWBWHdrZLdCHBBC
      PsnGsssGNsNRFsLGwMVNccJVmbjcjJblbzTVjlTz
      RfBqNfVmPLTTTVRZMMBWjlMvBgbbMs
      rHJzDwJdHzQgbMQlWMhd
      HtJrpCcHflLPFfpq
      SSGtmjQFStDbQbqGWJNnpZwgPsZjnJNNfZ
      RdClRMhlldHdlvdThNgwfJNRspNwJpwZcN
      CMBLgvvBLhrrBHTCVVLBQrWtbrDGmbtWGtzDQFGb
      ZRRCqHpRdztLSqWz
      hRsGjMVccGshPVDVcBmfgFFzggFgfBmWWtSd
      PVjlGhcGJjGPsGMjjDVrMTpRnvRZlHnZNNQbHppTTC
      QjbjWWlndRbwwwQWQdtpTVVZtzRPhHDzThhP
      fFfLsvrLCrmvGlSfLSrlPHThDzTztHVtzDzGtTVh
      fvrgsfccFLLLSvfMCCSWBjdMqdqNWBdBQNnWld
      pjGPvvbllvqGvGjwMbpbRmgSmSwtRtShgSSWWQmW
      DffTZLLzFFFTCRJMhWBzhmhgJt
      CVVZLLTTsZTFCnMffMTFHffLVpGpNqGjNbNPljqVPcGNGlcv
      rvJfztqQJqqrqHHwCzClTbBhDBBDrbSgphbVTrrV
      FFGdNWFLGWMmLDbpRwVbgRBp
      dmNGmZjMjQwtHCCw
      MSGbqbqMbbGDhSSGDhLNBPNcrDPPfzfczPfrnv
      rRwsrljslRgslwwgpssCjRtBNvnmPmBmccvmPnmzcP
      CjVjsssJQpTCrCCgHJLMSZbhMhWGZhHG
      JtBGBFGRVGVLLctRttthLFRBDQlDppljJwNQlpHHQqDHbHHN
      szSZTrzdzTSMdzsmsqqQqwdbgDNqgQNjlN
      SzmrlWPrlfPMsMZTPtCVCFRhhvhccLFPvL
      chmbsMDMMcBnGbZBzZGL
      JjjgJrJJggNgtrQSQBLjWBZlGnnB
      rFNrFtFCRNVrrsHmMDcsLqMhMF
      DLMwrBGgrBBDrcBcNBgWhpGhqVhhqSjqqqmjjp
      JfJCZCdtlbZlHHbjWVpPmHWb
      lTtZtnFQCztWFzJflZLcsrLFNDRNBcswcLMM
      tsVttVCBsCcCqPqwvtqNPQjWDDWjzQQWnpJQSrWJJN
      LMRdZvHGgMmZZGGLGLbhLhJpjWrSjndWJpSJrJppJnpj
      RhRgLMlmgMGMFGLlTtcBvwcfFCtVvfFT
      llBBmtncBglfqwsdwsjdbHwQHm
      zGRhPJvFzhvFvMDGFvGPwSWWQpdpHSwSjWjHsWMw
      JGFhDPrLTzhLhvFPzPjLjTzFlBqltnCqqBffcTgfnZfCfCnB
      QWQGNHQBffCNDMPdRTDLPVMN
      hrtlhtzZwJtwwgFgtlJthJJtZMqPVVpLmDVqRDmVPmMPVRTV
      SJSSnJwJlsFFvcHSBbfLQHGL
      zMNVzhNFsdNssmhlvtQvlttBlVGbTt
      wHpFwjHjLFHlwtncTQlnwn
      CCpjpqLCLqJggghqRmFsNRFmPszh
      CTjmprmNcnmCNVQbstnstvbnQv
      jqqdGhHgPRdfRRQvfLQffz
      BGgqBhMdgqBHMDDqqMPwgdhSTJNjjmJWWCTCCmwTWZNpmZ
      LqSDFFmdqDBDbbBHWl
      dQcRpgwRQPngBWHbVWht
      vdQMJQCQQvrJNqrTNsSZSmZT
      cqrHcHHFNFPLLNPHLWnHHFHFjvlbZfWjSjBjZfSblhbBSbSf
      VdVTGwTzTwTpMJslvjfsbbZSvnBClj
      nJdGmmTpTTdmNQNNLPPmDFQL
      VcjpTTtpcbThJBTTcjBvSPJzJlvPlwfJrgrgvw
      dmshCNqnqdhmRsCsqCnrNgPPrPfzrNLfSwSgzl
      ddQZdFnhsMttFTbDDD
      hLThMTSdfMzzLzTLsFTbwtDvtsFTnttF
      pZlNllPWrPCQPQlWNqjrqrjsnfDFbbtbstwswtvDnwtwjt
      pCNNQBCClQrplrfHQpQdSRMSVRhJzRchRhGHSh
      RZfVfRnTcPQWZcRVcRNSvljQsSSjNvvNqvss
      pwbwgmqJhGlNvvzgMM
      pthrhpmthmwhHHpLbbdrJmLWWRPTRZnCnPCPBnWTWTZq
      nzsJJsMjGMMsQFbnNmLnmCfb
      HlllPPTPlWTPDRRDRHcwwhrLLZfQmgmmQCFHvNZCgfggZQ
      lPcNTwNWddGsMSttdjzj
      bTbJZJDVFdqpBZTFTZJprdcsjjGszmjQszcjzDvsgccv
      HHLnhMNCCPhfhCLMlPlnvgGfctscSvtSjGjztQtm
      wWNQMPPMwlPHHPnnRLwWpJbrbbqbdppqJVJdZV
      gpgpNnnrhwBVWFqgjqqF
      ZCTsdRbCGZpZzCSGbWmtMBmWtqBBqdjjmq
      LcsTSlplZrJNcQQPvH
      DJDpMcqJDcDddNcJPGcJGFfnfZZmZZfRQZRNmVQVnBNn
      WWThvSSHFshlSsHvgTHLlzBQfVWwmwnnfmRQWnQVRn
      vljlgHjhstHbLhjLjrbPqMGJcJFJCMPrdF
      pJlPMpMBrrMcnrBBMMrvdhdgFvmcFdWtmdtftg
      bVVRmTRVTVVSVVVzZZqsggFHWTWtWffWFfWdtHdH
      RjLQDSzmVsjRRZSZQrCMJDPwlnJJnGGrPB
      GRgJtglPGlCrhQQrfW
      vSjvZvZHNBjZSvwjvmvNDqhhFqhHrMhrHpfWqQfhpW
      NBmwDSbZbvsNNBjmZfJzJgbVnGJbzVzPVRtL
      QQZVQCdlVmdZnWmJBrLwSJRdggwdJr
      DqHhPhcpvDqPFjhHjtFPssSJNfSBwBvffrgJwwJLBJbr
      jpsHcptHsqtPttsjctpFhGlZwCMlWMmWGCWVQnTMVWmz
      zzvnHjHWSfnvzpnfSRHdgrrsmWmhVrrwwbTrTmsrwm
      NlLNGqqclqlZZCLCGGCPllJhhPJbrmpmrwVshFVsJbwr
      DMLDNCZQCGLQGDtQpGtMjRdfdSRSSBtjtBjfjgjS
      WBBJfjBQJjftGCbttVJptC
      sdlmTHsqNsqpRtGcbWdbnR
      svNMhmWHNmvmvHZWTvBQDgSSjDFPSBSFPP
      mrlgqncgwHdqWWhRNtRttSvbRwwSvN
      jZLCZVZzVcCTcpCDVSBBSbvvRFbfDBSDNS
      VPJVpQjTZLjVLJJQGZTZGcQVghsGlmhshlqnghqrdrgldhlW
      qwGDMqMFWbFbqbDwMgqgnjfnffffcTTjNnpTfBncZZ
      lSdclSltlzPsJlhNNfTQPTmQhpPh
      LtllsscLLLvvJlSzWGqwrDGqvbqMwMGb
      bnfvnnQsVTdHQDmdNN
      fwlttwrfSfLwdGZGmGND
      qlPrjjplfSpjSltfttBBsvgzgbgnggBqWVvC
      HHrBSmBqBHdHCFcQsc
      WqtMDDnMMZhMhcsQVM
      bqtbGDLLTTnRPwvGgBNmNrwvjm
      RwWzWFwBcdSdMgJW
      mrTjVQDQthQvjrvTmggFbbdgSJcJDFgSdg
      phhFtvjNvFvTTvmTHZzlGlzZRZLBlzRp
      cHlZmZmJSHZcTVGmvZVcGVHlNtbDNbtWFWdtlbCWbWtQDFdr
      pwfwgRhngPjjtdWdNtFrdFwT
      RTgMpfhBcMJGHqcz
      dmCbpCLQVFmCRddCTFLCgZtWPNBhSNNwZWgWZvSwhN
      rDzGDjJHhhwzThBS
      rJrclsjjsJMJnJMLnbQQQFmRTqLVRT
      TgFTGPtrWHzgCJDz
      fQbfLwbbFbWjHJHWjd
      LvQvwVfQvQhLLLLsmMBfLfBhqchtGFSNSFNqrSqPcqSGttSN
      MsMmFgTVMMgMdFVMhdzWqCCBCWjWqBWqhzzL
      nHfZDlbvcrDpcpcfDJbNJqGLbCjBmjLzJC
      RnDZHwmmTwVMTsMS
      NpdpdnjNCRjBnHRPpBDnhSdSwFFLFdScFFWcFWLd
      stqMrMZtsQMJmMqvrtqMbstQVchPFWgFVVFVwfWJcSSWVSSV
      MQrZzbvMrrrZZtZmstMtMsDRRjPHCGTjBnzpnDHTCGjG
      ClGGvDMGMNhNSmFVPbpgFgmFgZPb
      WhTTLWsBBWTcrPpggtQpsQFpVb
      fBRTqWLjTrzDNhMvCSGDzl
      jbzjttVzpbWzWVbTtzWzVwPbPPcwDDccccFNFLMFsm
      rlghJZHmCHvHJvRLSNLhhhccNPwcMP
      QffmBZRBGtVTBdTG
      bDRqHwwRpNPnbppn
      FqrlQSQJSVsQrSCmpdPNpcNCcP
      jFZjrssjBhrZVhJLLGHfMHfwtqRjMqRTvD
      SMMCTBzFfSRhTThCSMRSzzHnJgqGDHQgGVDnqrqnqqnqcQ
      ljvjpWPbrWWtrbmDVDlmnDnqVmgJ
      bNjsNPrNPtswfZzfTSTBwhSM
      hNMNdssdMqdTQchqgNZzHtwmwGHHzmQZGHDH
      JrbJvJrvLrPjrPCVCjRBLPbzfRFZmzwHgFHmGHmwFwzFZR
      rpbrvVjPCBbCJrCSLSPsTlphNncMglcNTMWMql
      fGWGHbrllCCWWllFNPQSZvdPSvdZTffZ
      tqssVjJMJWzWVvSvWS
      qtwMwDWjnRRwssWjngwjjnhhDcCLhhCFHlcmcbCHFmDC
      rFTdFjdRDTTlDWCqvhwLhwZdLS
      QzfJfnfsbsJHMnNmHhVpCZwSQSWqSqVQhS
      nJnczsHzNMmBJnbnbNwnfzJfcDTltllRTgPlFlgPrTDjPRGl
      ZLCGDvvJlvGChSPZWPSsZWdRRN
      rQccBwcccnHmQggnVLPLWpgVWPpWzSRs
      fmwTfTHnMBTfJDbfftJLvhlL
      """;

}
