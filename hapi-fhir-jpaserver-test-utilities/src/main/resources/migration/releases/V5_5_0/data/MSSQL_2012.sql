INSERT INTO HFJ_RESOURCE (
   RES_ID,
   RES_VERSION,
   HAS_TAGS,
   RES_PUBLISHED,
   RES_UPDATED,
   SP_HAS_LINKS,
   HASH_SHA256,
   SP_INDEX_STATUS,
   SP_CMPSTR_UNIQ_PRESENT,
   SP_COORDS_PRESENT,
   SP_DATE_PRESENT,
   SP_NUMBER_PRESENT,
   SP_QUANTITY_NRML_PRESENT,
   SP_QUANTITY_PRESENT,
   SP_STRING_PRESENT,
   SP_TOKEN_PRESENT,
   SP_URI_PRESENT,
   RES_TYPE,
   RES_VER
)
   VALUES (
   1653,
   'R4',
   'false',
   '2023-06-15 09:58:42.92',
   '2023-06-15 09:58:42.92',
   'false',
   '6beed652b77f6c65d776e57341a0b5b0596ac9cfb0e8345a5a5cfbfaa59e2b62',
   1,
   'false',
   'false',
   'false',
   'false',
   'true',
   'false',
   'false',
   'true',
   'true',
   'Observation',
   1
);


INSERT INTO HFJ_IDX_CMB_TOK_NU (
   PID,
   HASH_COMPLETE,
   IDX_STRING,
   RES_ID
) VALUES (
   10,
   '5570851350247697202',
   'Patient?birthdate=1974-12-25&family=WINDSOR&gender=http%3A%2F%2Fhl7.org%2Ffhir%2Fadministrative-gender%7Cmale',
   1653
);
