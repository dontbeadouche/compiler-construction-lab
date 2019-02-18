digit [0-9]

%%

{digit}{2} {printf("Matched\n");}

.* {printf("Unmatched\n");}

%%
