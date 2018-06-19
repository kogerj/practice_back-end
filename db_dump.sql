CREATE TABLE users (
    id integer NOT NULL,
    account_id character varying(150) NOT NULL,
    nickname character varying(100) NOT NULL,
    password character varying(100) NOT NULL,
    created_dt timestamp without time zone DEFAULT now(),
    last_login_dt timestamp without time zone,
    verified_dt timestamp without time zone,
    active_days integer DEFAULT 0,
    moderator boolean DEFAULT false,
    ban boolean DEFAULT false NOT NULL,
    ban_reason character varying(255),
    ban_end_dt timestamp without time zone,
    network_id integer DEFAULT 0 NOT NULL,
    play_time_left integer DEFAULT 43200 NOT NULL,
    total_play_time integer DEFAULT 0 NOT NULL,
    settings text,
    zone_id integer,
    gold integer DEFAULT 10 NOT NULL,
    silver integer DEFAULT 800 NOT NULL,
    active boolean DEFAULT false,
    reference integer,
    updated_dt timestamp without time zone,
    nickname_changed boolean DEFAULT false NOT NULL,
    gold_contests_unlocked boolean DEFAULT false NOT NULL,
    shards integer DEFAULT 0 NOT NULL
);

CREATE TABLE admins (
    id integer NOT NULL,
    username character varying(50),
    password character varying(50),
    token character varying(255),
    token_created_dt timestamp without time zone,
    last_login_dt timestamp without time zone,
    moderator boolean DEFAULT false NOT NULL
);

COPY users (id, account_id, nickname, password, created_dt, last_login_dt, verified_dt, active_days, moderator, ban, ban_reason, ban_end_dt, network_id, play_time_left, total_play_time, settings, zone_id, gold, silver, active, reference, updated_dt, nickname_changed, gold_contests_unlocked, shards) FROM stdin;
164	anton	Vitenka	da39a3ee5e6b4b0d3255bfef95601890afd80709	2018-03-22 19:28:56.027485	2018-03-23 15:51:43.206051	\N	2	f	f	\N	\N	1	41210	2094	\N	1	10	1300	t	0	2018-03-23 15:52:12.64931	f	f	0
174	kosvas12	kosvas12	da39a3ee5e6b4b0d3255bfef95601890afd80709	2018-03-23 11:00:53.851447	2018-03-23 11:00:54.47103	\N	1	f	f	\N	\N	1	43131	69	\N	2	10	1000	t	0	2018-03-23 11:01:34.585967	f	f	0
184	g10153181653008456203	SuperDuperArtist21	da39a3ee5e6b4b0d3255bfef95601890afd80709	2018-03-23 16:21:06.345888	2018-03-23 16:21:07.065719	\N	1	f	f	\N	\N	1	39580	3620	\N	1	10	1000	t	0	2018-03-23 16:51:23.848435	f	f	0
176	kosvas14	kosvas14	da39a3ee5e6b4b0d3255bfef95601890afd80709	2018-03-23 11:19:24.233801	2018-03-23 11:20:04.430142	\N	1	f	f	\N	\N	1	43096	104	\N	2	10	1000	t	0	2018-03-23 11:20:37.940295	f	f	0
159	kosvas	kosvas	da39a3ee5e6b4b0d3255bfef95601890afd80709	2018-03-22 12:00:13.961373	2018-03-22 12:00:19.790687	\N	1	f	f	\N	\N	1	43200	0	\N	2	10	1000	t	0	2018-03-22 12:00:31.315197	f	f	0
179	anton1	Vitenka	da39a3ee5e6b4b0d3255bfef95601890afd80709	2018-03-23 11:58:21.846916	2018-03-23 14:41:50.945059	\N	1	f	f	\N	\N	1	42026	1174	\N	1	10	1000	t	0	2018-03-23 14:43:24.838523	f	f	0
163	123456712312311	HujuJebanyVRotSukaTupaja	da39a3ee5e6b4b0d3255bfef95601890afd80709	2018-03-22 18:28:29.922694	2018-03-24 12:16:50.00926	\N	3	f	f	\N	\N	1	41500	24330	\N	1	10	1700	t	0	2018-03-24 12:20:01.173979	f	f	0
168	kosvas6	kosvas6	da39a3ee5e6b4b0d3255bfef95601890afd80709	2018-03-23 07:19:24.068852	2018-03-23 07:24:14.883132	\N	1	f	f	\N	\N	1	42437	763	\N	2	10	1000	t	0	2018-03-23 07:28:50.238094	f	f	0
160	kosvas2	kosvas2	da39a3ee5e6b4b0d3255bfef95601890afd80709	2018-03-22 12:05:38.138334	2018-03-22 12:05:38.666746	\N	1	f	f	\N	\N	1	43200	0	\N	2	10	1000	t	0	2018-03-22 12:05:43.509526	f	f	0
173	kosvas11	kosvas11	da39a3ee5e6b4b0d3255bfef95601890afd80709	2018-03-23 10:52:32.750493	2018-03-23 10:52:33.260993	\N	1	f	f	\N	\N	1	43115	85	\N	2	10	1000	t	0	2018-03-23 10:53:21.06634	f	f	0
165	g07569229402359604963	WideEyedGoblin45841	da39a3ee5e6b4b0d3255bfef95601890afd80709	2018-03-22 22:24:12.449961	2018-03-24 11:49:53.849994	\N	3	f	f	\N	\N	1	18267	54799	\N	1	10	1400	t	0	2018-03-24 13:56:18.285814	f	f	0
161	kosvas3	kosvas3	da39a3ee5e6b4b0d3255bfef95601890afd80709	2018-03-22 12:12:45.125608	2018-03-22 12:12:45.847553	\N	1	f	f	\N	\N	1	43200	0	\N	2	10	1000	t	0	2018-03-22 12:12:59.764135	f	f	0
158	anton20111	Anton	da39a3ee5e6b4b0d3255bfef95601890afd80709	2018-03-22 11:36:01.605897	2018-03-22 12:13:57.193246	\N	1	f	f	\N	\N	1	43200	0	\N	2	10	900	t	0	2018-03-22 12:14:01.371044	f	f	0
169	kosvas7	kosvas7	da39a3ee5e6b4b0d3255bfef95601890afd80709	2018-03-23 07:40:38.401618	2018-03-23 07:40:43.977966	\N	1	f	f	\N	\N	1	42948	252	\N	2	10	1000	t	0	2018-03-23 07:43:00.84882	f	f	0
166	kosvas4	kosvas4	da39a3ee5e6b4b0d3255bfef95601890afd80709	2018-03-23 06:43:30.063556	2018-03-23 06:43:30.40981	\N	1	f	f	\N	\N	1	41266	1934	\N	2	10	900	t	0	2018-03-23 07:00:54.967174	f	f	0
170	kosvas8	kosvas8	da39a3ee5e6b4b0d3255bfef95601890afd80709	2018-03-23 07:45:09.82614	2018-03-23 08:56:20.44388	\N	1	f	f	\N	\N	1	42143	1057	\N	2	10	1000	t	0	2018-03-23 08:56:56.633099	f	f	0
175	kosvas13	kosvas13	da39a3ee5e6b4b0d3255bfef95601890afd80709	2018-03-23 11:07:26.347417	2018-03-23 11:07:26.86131	\N	1	f	f	\N	\N	1	43097	103	\N	2	10	1000	t	0	2018-03-23 11:08:23.793406	f	f	0
167	kosvas5	kosvas5	da39a3ee5e6b4b0d3255bfef95601890afd80709	2018-03-23 07:06:07.539089	2018-03-23 07:06:13.167392	\N	1	f	f	\N	\N	1	41806	1394	\N	2	10	1000	t	0	2018-03-23 07:18:16.790008	f	f	0
182	g12716946517771568240	qlex2001	da39a3ee5e6b4b0d3255bfef95601890afd80709	2018-03-23 16:05:36.293409	2018-03-23 18:11:26.349777	\N	1	f	f	\N	\N	1	39112	4088	\N	1	10	1000	t	0	2018-03-23 18:27:55.55848	f	f	0
172	kosvas10	kosvas10	da39a3ee5e6b4b0d3255bfef95601890afd80709	2018-03-23 10:32:20.179359	2018-03-23 10:32:20.634346	\N	1	f	f	\N	\N	1	43142	58	\N	2	10	1000	t	0	2018-03-23 10:32:55.012505	f	f	0
180	anton2	Vitenka	da39a3ee5e6b4b0d3255bfef95601890afd80709	2018-03-23 11:58:24.429629	2018-03-23 14:43:39.300574	\N	1	f	f	\N	\N	1	42312	888	\N	1	10	1000	t	0	2018-03-23 14:43:52.013218	f	f	0
177	kosvas15	kosvas15	da39a3ee5e6b4b0d3255bfef95601890afd80709	2018-03-23 11:21:31.494575	2018-03-23 11:21:32.016826	\N	1	f	f	\N	\N	1	43142	58	\N	2	10	1000	t	0	2018-03-23 11:22:15.44184	f	f	0
171	kosvas9	kosvas9	da39a3ee5e6b4b0d3255bfef95601890afd80709	2018-03-23 10:03:46.570728	2018-03-23 10:03:47.16999	\N	1	f	f	\N	\N	1	43096	104	\N	2	10	1000	t	0	2018-03-23 10:04:47.783194	f	f	0
178	kosvas16	kosvas16	da39a3ee5e6b4b0d3255bfef95601890afd80709	2018-03-23 11:31:18.295951	2018-03-23 11:31:18.720816	\N	1	f	f	\N	\N	1	43120	80	\N	2	10	1000	t	0	2018-03-23 11:32:06.798453	f	f	0
183	g09239037833239896292	StingingKey82	da39a3ee5e6b4b0d3255bfef95601890afd80709	2018-03-23 16:16:38.452182	2018-03-24 10:52:04.606928	\N	2	f	f	\N	\N	1	41705	3415	\N	1	10	1300	t	0	2018-03-24 11:04:34.941159	f	f	0
181	kosvas17	kosvas17	da39a3ee5e6b4b0d3255bfef95601890afd80709	2018-03-23 13:00:31.484037	2018-03-23 14:42:55.851642	\N	1	f	f	\N	\N	1	42776	424	\N	1	10	1000	t	0	2018-03-23 14:42:58.496952	f	f	0
162	anton201111	Anton	da39a3ee5e6b4b0d3255bfef95601890afd80709	2018-03-22 12:14:18.040438	2018-03-23 15:50:50.790991	\N	2	f	f	\N	\N	1	38025	9786	\N	1	10	1000	t	0	2018-03-23 15:52:10.40229	f	f	0
\.

COPY admins (id, username, password, token, token_created_dt, last_login_dt, moderator) from stdin;
2	mihklimaja123	asd123 NULL	2017-02-02 00:00:00	2018-03-04 00:00:00	false
3	Boss	Boss123 NULL	2010-01-01 08:01:01	2018-06-06 19:12:12	false
4	THEONE	123BOSS NULL	2000-01-01 08:01:01	2018-06-19 08:07:35	true
5	spongebob	asdasd NULL	2016-02-02 08:10:56	2018-06-19 15:08:01	true
6	hardatwork	workwork NULL	2011-04-05 10:11:01	2017-05-11 07:00:00	true
1	MarkoMärtin	Marko123 NULL	2007-06-09 09:09:09	2018-05-01 18:08:09	false
\.